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

    public ItemDTO(int itemIdentifier, String itemDescription, double price, String name, int vatRate){
        this.itemIdentifier = itemIdentifier;
        this.itemDescription = itemDescription;
        this.name = name;
        this.price = price;
        this.vatRate = vatRate;
    }
    
}
