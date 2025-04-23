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
    


    
    @BeforeEach 
    public void setUp(){
        exSystems = new RegistryCreator();
        printer = new Printer();
        testSale = new Sale(exSystems, printer);
    }
     
    @AfterEach
    public void tearDown() {
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

    





}
