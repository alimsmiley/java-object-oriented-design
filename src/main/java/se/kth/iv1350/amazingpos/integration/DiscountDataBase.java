/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.*;
import se.kth.iv1350.amazingpos.placeholders.PlaceholderDatabase;

/**
 *
 * Interacts with an external database that handles customer discounts.
 */
public class DiscountDataBase {
    
    /**
     * Sends customer and sale information to an external database that finds all discounts the customer is eligible for.
     * @param currentSale SaleDTO with all the sale information
     * @param customerID Unique int assigned to the customer for identification
     * @return a DTO that conatining all discounts the customer is eligible for
     */
    public DiscountDTO searchForDiscount(SaleDTO currentSale, int customerID){
        DiscountDTO totalDiscount;
        // sends a request to the external database that either doesnt return anything usefull or returns the data so we can create a ItemDTO
        DiscountDTO placeholderDiscountDTO = PlaceholderDatabase.findDiscountPlaceHolderDatabase(currentSale, customerID);
       
        totalDiscount = new DiscountDTO(placeholderDiscountDTO);
       
        return totalDiscount;

    }
}
