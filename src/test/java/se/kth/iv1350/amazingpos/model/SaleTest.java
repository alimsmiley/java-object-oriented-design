package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*; 

import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;


public class SaleTest {
    
    private RegistryCreator exSystems;
    private Printer printer;
    private Sale testSale;
    private int validItemIdentifier = 1;
    private int invalidItemIdentifier = 150;
    private int quantity = 2;

    private int validCustomerID = 123;
    private int invalidCustomerID = 111;
    
    private double paidAmountMore = 425;
    private double paidAmountExact = 345;
    private Payment payment;


    double paid = 1000;
    double change;


    
    @BeforeEach 
    void setUp(){
        exSystems = new RegistryCreator();
        printer = new Printer();
        testSale = new Sale(exSystems, printer);

    }
     
    @AfterEach
    void tearDown() {
        exSystems = null;
        printer = null;
        testSale = null;

    }


    @Test
    void testRegisterValildItemIdentifier(){
        SaleDTO registeredSale = testSale.registerItem(validItemIdentifier, quantity);
        ItemDTO registeredItem = registeredSale.getLastRegisteredItem();

        boolean result = false;
        if (registeredItem instanceof ItemDTO) {
            result = true;
        }

        assertTrue(result, "Object not instance of ItemDTO");  
    }

    @Test
    void testRegisterInvalidItemIdentifier(){
        SaleDTO registeredSale = testSale.registerItem(invalidItemIdentifier, quantity);
        ItemDTO result = registeredSale.getLastRegisteredItem();
        ItemDTO expectedResult = null;

        assertEquals(result, expectedResult, "Object not instance of ItemDTO");   
    }


    @Test
    void testShopingListLengthIsCorrect(){
        testSale.registerItem(validItemIdentifier, quantity); 
        testSale.registerItem(invalidItemIdentifier, quantity);
      
        int expectedResult = 1;

        int result = testSale.getShoppingCart().getShoppingList().size();

        assertEquals(result, expectedResult, "Shopinglist has wrong size");  
    }

    @Test
    void testIfVatIsUpdated(){
        testSale.registerItem(validItemIdentifier, quantity); 
        double result = testSale.getVat();
        double expectedResult = 45;
        assertEquals(expectedResult, result, "Vat rate is not updated correctly!");

    }

    @Test
    void testIfRunningTotalIsUpdated(){
        testSale.registerItem(validItemIdentifier, quantity); 
        double result = testSale.getRunningTotal();
        double expectedResult = 345;
        assertEquals(expectedResult, result, "Running total is not updated correctly!");
    }



    @Test
     void testCheckForDiscountEligibleDiscountIsApplied(){
        testSale.registerItem(validItemIdentifier, quantity); 
        SaleDTO currentSale =  testSale.checkForDiscount(validCustomerID);
        double result = currentSale.getRunningTotal();

        double expectedResult =  345 - 345*0.15;
        assertEquals(result, expectedResult, "Customer eligible for discount didnt get discount!");        

    }

    @Test
    void testCheckForDiscountNotEligibleDiscountIsNotApplied(){
        testSale.registerItem(validItemIdentifier, quantity); 
        SaleDTO currentSale =  testSale.checkForDiscount(invalidCustomerID);
        double result = currentSale.getRunningTotal();

        double expectedResult =  345;
        assertEquals(result, expectedResult, "Customer not eligible for discount misstakenly got discount!"); 

    }


    @Test
    void testEndSaleWithNoBoughtItems(){
        double result = testSale.endSale();

        double expected = 0;
        assertEquals(expected, result, "Failed to end sale");
    }

    @Test
    void testEndSaleWithBoughtItems(){
       
        testSale.registerItem(validItemIdentifier, quantity); 
        double result = testSale.endSale();
        double expected = 345;

        assertEquals(expected, result, "Failed to end sale");
    }

    @Test
    void testPayTooMuch(){
        testSale.registerItem(validItemIdentifier, quantity);
        testSale.endSale();
        payment = new Payment(paidAmountMore);
        double result = testSale.pay(payment);
        double expectedResult = 80;

        assertEquals(result, expectedResult, "Change is incorrect");
    }
    
    @Test
    void testPayExact(){
        testSale.registerItem(validItemIdentifier, quantity);
        testSale.endSale();
        payment = new Payment(paidAmountExact);
        double result = testSale.pay(payment);
        double expectedResult = 0;

        assertEquals(result, expectedResult, "Change is incorrect");
    }



    
    @Test
    void testPrintReceipt() {
        testSale.registerItem(validItemIdentifier, quantity);
        testSale.endSale();
        payment = new Payment(paidAmountExact);
        testSale.pay(payment);
        testSale.printReceipt(paid, 655);

    }

}