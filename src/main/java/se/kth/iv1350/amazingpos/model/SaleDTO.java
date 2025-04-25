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
    private double runningTotal;
    private LocalTime saleTime;
    private double vat;

    /**
     * Creates a new instance of SaleDTO.
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
     * Overloaded constructor that creates a new instance of SaleDTO given a {@link currentSale} instead.
     * @param currentSale   The current active sale.
     */
    public SaleDTO(Sale currentSale){
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
            //should throw an exception here!
            System.out.println("Item invalid");
        }
    }

    public ItemDTO getLastRegisteredItem() {
        return lastRegisteredItem;
    }

    public ShoppingList getListOfRegisteredItem(){
        return new ShoppingList(this.listOfRegisteredItem);
    }

    public double getRunningTotal(){
        return runningTotal;
    }

    public LocalTime getSaleTime(){
        return saleTime;
    }

    public double getTotalVat(){
        return vat;
    }


}
