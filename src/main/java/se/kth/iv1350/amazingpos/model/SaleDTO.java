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
     * Creates a new instance of SaleDTO given {@link currentSale} and {@link item}
     * @param currentSale The current sale
     * @param item  The item to be added.
     */
    public SaleDTO(Sale currentSale, ItemDTO item){
        this.lastRegisteredItem = item;
        this.listOfRegisteredItem = currentSale.getShoppingCart();
        this.runningTotal = currentSale.getRunningTotal();
        this.saleTime = currentSale.getSaleTime();
        this.vat = currentSale.getVat();
    }

    public void checkItemValidity(){
        if(lastRegisteredItem == null){
            System.out.println("Item invalid");
        }
    }

    public ItemDTO getLastRegisteredItem() {
        return lastRegisteredItem;
    }

    public ShoppingList getShoppingList(){
        return listOfRegisteredItem;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public LocalTime getSaleTime(){
        return saleTime;
    }

    public int getTotalVat(){
        return vat;
    }


}
