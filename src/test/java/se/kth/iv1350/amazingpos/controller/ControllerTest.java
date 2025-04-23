package se.kth.iv1350.amazingpos.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;
import se.kth.iv1350.amazingpos.model.*;

public class ControllerTest {
    static private Sale currentSale;
    static private RegistryCreator externalSystems;
    static private Printer printer;
    static private Controller controller;

    private int validItemIdentifier = 1;
    private int inValidItemIdentifier = 7;
    private int  quantity = 2;



    @BeforeAll
    static void setUpClass(){
        printer = new Printer();
        externalSystems = new RegistryCreator();
        currentSale = new Sale(externalSystems, printer);
        controller = new Controller(externalSystems, printer);

    }

    @BeforeEach
    void setUp(){

    }

   
    
    
    
    @Test
    void testAddItem() {

    }

    @Test
    void testStartSale() {

    }

    @Test
    void testIfAddItemReturnsSaleDTO(){



    }

    @Test
    void testIfErrorMessageIsPrinted(){

    }


}
