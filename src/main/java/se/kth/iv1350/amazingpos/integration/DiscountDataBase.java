/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.*;
import se.kth.iv1350.amazingpos.placeholders.PlaceholderDatabase;

/**
 *
 * Includes database for all discount types
 */
public class DiscountDataBase {
    /**
     * Creates an instance of discount database
     */
    DiscountDataBase(){

    }


    public DiscountDTO searchForDiscount(SaleDTO currentSale, int customerID){
        DiscountDTO totalDiscount;
        // sends a request to the external database that either doesnt return anything usefull or returns the data so we can create a ItemDTO
        DiscountDTO placeholderDiscountDTO = PlaceholderDatabase.findDiscountPlaceHolderDatabase(currentSale, customerID);
       
        totalDiscount = new DiscountDTO(placeholderDiscountDTO);
       
        return totalDiscount;

    }
}
