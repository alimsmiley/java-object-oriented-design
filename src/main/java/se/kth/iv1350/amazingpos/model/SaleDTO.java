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
    /**
     * Checks if the item is valid or not.
     */
    public void checkItemValidity(){
        if(lastRegisteredItem == null){
            System.out.println("Item invalid");
        }
    }
    /**
     * Gets the last registered item.
     * @return  The last registered item
     */
    public ItemDTO getLastRegisteredItem() {
        return lastRegisteredItem;
    }
    /**
     * Gets the list of all registered items
     * @return  List of registered items.
     */
    public ShoppingList getListOfRegisteredItem(){
        return new ShoppingList(this.listOfRegisteredItem);
    }
    /**
     * Gets the current running total.
     * @return  Running total.
     */
    public int getRunningTotal(){
        return runningTotal;
    }
    /**
     * Gets the time of sale.
     * @return  Sale time.
     */
    public LocalTime getSaleTime(){
        return saleTime;
    }
    /**
     * Gets the total vat ammount. 
     * @return  Total ammount of vat.
     */
    public int getTotalVat(){
        return vat;
    }


}
