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
    private double vatRate;
    /**
     * Creates a new instance of ItemDTO.
     * @param itemIdentifier    The items identifier.
     * @param itemDescription   The items description.
     * @param price The items price.
     * @param name  The items name.
     * @param vatRate   The items VAT rate.
     */
    public ItemDTO(int itemIdentifier, String itemDescription, double price, String name, double vatRate){
        this.itemIdentifier = itemIdentifier;
        this.itemDescription = itemDescription;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
    }
    /**
     * Overloaded constructor with a {@link placeHolderDTO} as argument.
     * @param placeHolderDTO The itemDTO used to create a new itemDTO.
     */
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

    public double getVatRate(){
        return vatRate;
    }


}
