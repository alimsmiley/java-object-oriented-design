package se.kth.iv1350.amazingpos.integration;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;


import se.kth.iv1350.amazingpos.model.*;
import se.kth.iv1350.amazingpos.integration.*;




public class DiscountDataBaseTest {
    static  Sale sale;
    static  SaleDTO currentSale;
    static  RegistryCreator externalSystems;
    static  Printer printer;

    private int validCustomerID = 123;
    private int invalidCustomerID = 222;

    @BeforeAll
    static void setUpClass(){
        
        printer = new Printer();
        externalSystems = new RegistryCreator();
        sale = new Sale(externalSystems, printer);
        currentSale = new SaleDTO(sale);
        
    }


    @Test
    void testDiscountDTOReturned() {
        DiscountDTO currentDiscount = DiscountDataBase.searchForDiscount(currentSale, validCustomerID);

        //assertTrue(item instanceof ItemDTO);

    }
    @Test
    void testSearchForDiscount() {

    }
} 