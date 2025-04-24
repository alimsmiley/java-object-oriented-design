package se.kth.iv1350.amazingpos.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;
import se.kth.iv1350.amazingpos.model.*;

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

    @BeforeAll
    static void setUpClass(){
        printer = new Printer();
        externalSystems = new RegistryCreator();
        controller = new Controller(externalSystems, printer);
        controller.startSale();
    }

    @AfterAll
    static void tearDown(){
        printer = null;
        externalSystems = null;
        controller = null;    
    }
 
    @Test
    void testInvalidMaxQuantity() {
        SaleDTO current = controller.addItem(validItemIdentifier, invalidMaxQuantity);
        assertTrue(current == null, "invalid item quantity!");    
    }

    void testInvalidNegativeQuantity() {
        SaleDTO current = controller.addItem(validItemIdentifier, invalidNegativeQuantity);
        assertTrue(current == null, "invalid item quantity!");    
    }

 
    @Test
    void testIfAddItemReturnsSaleDTO(){
        SaleDTO current = controller.addItem(validItemIdentifier, quantity);
        assertTrue(current instanceof SaleDTO);
    }

    @Test
    void testIfAddedInvalidItemIsNullInLastRegisteredItem(){
        SaleDTO current = controller.addItem(inValidItemIdentifier, quantity);
        assertTrue(current.getLastRegisteredItem() == null, "invalid Item failed to return null! ");
    }
}
