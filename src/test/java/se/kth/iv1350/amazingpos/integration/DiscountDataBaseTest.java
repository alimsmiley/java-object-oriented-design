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
        DiscountDTO currentDiscount = externalSystems.getDiscountDataBase().
                                    searchForDiscount(currentSale, validCustomerID);

        assertTrue(currentDiscount instanceof DiscountDTO, "Instance DiscountDTO not returned");

    }
    @Test
    void testNotEligibleForDiscount() {
        DiscountDTO currentDiscount = externalSystems.getDiscountDataBase().
                                    searchForDiscount(currentSale, invalidCustomerID);
        boolean result = false;
        if(currentDiscount.getCustomerDiscount() == 0 
                && currentDiscount.getItemDiscount() ==0
                && currentDiscount.getTotalCostDiscount() == 0){
            result = true;
        }

        assertTrue(result, "Discount applied even if not eligible");
        
    }
} 