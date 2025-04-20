/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

/**
 *
 * @author 10478ALES
 */

public class ItemDTO {
    private int itemIdentifier;
    private String itemDescription;
    private double price;
    private String name;
    private int vatRate;
    /**
     * Creates a new instance of ItemDTO give
     * @param itemIdentifier
     * @param itemDescription
     * @param price
     * @param name
     * @param vatRate
     */
    public ItemDTO(int itemIdentifier, String itemDescription, double price, String name, int vatRate){
        this.itemIdentifier = itemIdentifier;
        this.itemDescription = itemDescription;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
    }
    

    public ItemDTO(ItemDTO placeHolderDTO){
        this.itemIdentifier = placeHolderDTO.getItemIdentifier();
        this.itemDescription = placeHolderDTO.getItemDescription();
        this.price = placeHolderDTO.getPrice();
        this.name = placeHolderDTO.getName();
        this.vatRate = placeHolderDTO.getVatRate();

    }

    public int getItemIdentifier(){
        return itemIdentifier;
    }

    public String getItemDescription(){
        return itemDescription;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public int getVatRate(){
        return vatRate;
    }


}
