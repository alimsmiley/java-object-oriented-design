package se.kth.iv1350.amazingpos.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.integration.*;

public class SaleTest {
    
    private RegistryCreator exSystems;
    private Printer printer;
    private Sale testSale;
    private int validItemidentifier;
    private int invalidItemIdentifier;
    private int quantity;
    


    
    @BeforeAll
    void setUpClass(){
        exSystems = new RegistryCreator();
        printer = new Printer();
        testSale = new Sale(exSystems, printer);
        
    }


    @Test
    void testRegisterItem(){
        
    }
}
