/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

import java.time.LocalTime;

/**
 *
 * Contains information about the current sale
 */
public class SaleDTO {
    private ItemDTO lastRegisteredItem;
    private ShoppingList listOfRegisteredItem;
    private int runningTotal;
    private LocalTime saleTime;
    private int vat;

    /**
     * Creates and instance of SaleDTO
     */
    public SaleDTO(){

    }

    private void checkItemValidity(){
        if(lastRegisteredItem == null){
            System.out.println("Item invalid");
        }
    }
}
