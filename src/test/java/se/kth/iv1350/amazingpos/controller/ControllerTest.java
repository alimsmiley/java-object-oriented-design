package se.kth.iv1350.amazingpos.controller;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;
import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.SaleDTO;

public class ControllerTest {
    static  Sale currentSale;
    static  RegistryCreator externalSystems;
    static  Printer printer;
    static  Controller controller;

    private int validItemIdentifier = 1;
    private int inValidItemIdentifier = 7;
    private int  quantity = 2;
    private int  invalidMaxQuantity = 1001;
    private int  invalidNegativeQuantity = -1001;
    private int customerID = 123;

    private double paidAmountMore = 1150;
    private double paidAmountExact = 765;

    private int validItemIdentifier1 = 1;
    private int validItemIdentifier2 = 2;
    private int validItemIdentifier3 = 3;

    private int  quantityX = 1;
   

    @BeforeEach
    void setUpClass(){
        
        printer = new Printer();
        externalSystems = new RegistryCreator();
        controller = new Controller(externalSystems, printer);
        controller.startSale();

    
    }

    @AfterEach
    void tearDown(){
        printer = null;
        externalSystems = null;
        controller = null;    
    }

    @Test
    void testStartSale(){
        controller.startSale();
    }
 
    @Test
    void testAddItemInvalidMaxQuantity() {
        SaleDTO current = controller.addItem(validItemIdentifier, invalidMaxQuantity);
        assertTrue(current == null, "invalid item quantity!");    
    }
    @Test
    void testAddItemInvalidNegativeQuantity() {
        SaleDTO current = controller.addItem(validItemIdentifier, invalidNegativeQuantity);
        assertTrue(current == null, "invalid item quantity!");    
    }

 
    @Test
    void testIfAddItemReturnsSaleDTO(){
        SaleDTO current = controller.addItem(validItemIdentifier, quantity);
        assertTrue(current instanceof SaleDTO);
    }

    @Test
    void testAddItemIfAddedInvalidItemIsNullInLastRegisteredItem(){
        SaleDTO current = controller.addItem(inValidItemIdentifier, quantity);
        assertTrue(current.getLastRegisteredItem() == null, "invalid Item failed to return null! ");
    }

    @Test
    void testSignalDiscount(){
        SaleDTO discountedSale = controller.signalDiscount(customerID);

        assertTrue(discountedSale instanceof SaleDTO, "signalDiscount doesn't return a SaleDTO");

    }

    @Test
    void testConcludeSaleWithBoughtItems(){
        controller.addItem(validItemIdentifier, quantity);

        double result = controller.concludeSale();
        double expected = 345;

        assertEquals(expected, result, "Failed to conclude sale");

    }

    @Test
    void testConcludeSaleWithNoBoughtItems(){
        

        double result = controller.concludeSale();
        double expected = 0;

        assertEquals(expected, result, "Failed to conclude sale");

    }

    @Test
    void testPayReturnsZeroChange(){
        controller.addItem(validItemIdentifier1, quantityX);
        controller.addItem(validItemIdentifier2, quantityX*2); 
        controller.addItem(validItemIdentifier3, quantityX*3); 
        controller.concludeSale();

        double result = controller.pay(paidAmountExact);
        double expected = 0;

        assertEquals(expected, result, "Change amount doesnt match!");

    }

    @Test
    void testPayReturnsRightChangeAmount(){
        controller.addItem(validItemIdentifier1, quantityX);
        controller.addItem(validItemIdentifier2, quantityX*2); 
        controller.addItem(validItemIdentifier3, quantityX*3); 
        controller.concludeSale();

        double result = controller.pay(paidAmountMore);
        double expected = 385;

        assertEquals(expected, result, "Change amount doesnt match!");

    }



}
