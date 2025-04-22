/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

/**
 *
 * Represents the item infomation
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
    /**
     * Overloaded constructor with a {@link placeHolderDTO} as argument.
     * @param placeHolderDTO The itemdto used to create a new itemDTO.
     */
    public ItemDTO(ItemDTO placeHolderDTO){
        this.itemIdentifier = placeHolderDTO.getItemIdentifier();
        this.itemDescription = placeHolderDTO.getItemDescription();
        this.price = placeHolderDTO.getPrice();
        this.name = placeHolderDTO.getName();
        this.vatRate = placeHolderDTO.getVatRate();

    }

    /**
     * Gets the item identifier from this instance of the itemDTO
     * @return Item identifier
     */
    public int getItemIdentifier(){
        return itemIdentifier;
    }

    /**
     * Gets the item Descrption from this instance of the itemDTO
     * @return Item description
     */
    public String getItemDescription(){
        return itemDescription;
    }

    /**
     * Gets the price of the item from this instance of the itemDTO
     * @return Price of the item
     */
    public double getPrice(){
        return price;
    }

    /**
     * Gets the name of the item from this instance of the itemDTO
     * @return The name of the item
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the vat rate for the item from this instance of the itemDTO
     * @return The item's vat rate
     */
    public int getVatRate(){
        return vatRate;
    }


}
