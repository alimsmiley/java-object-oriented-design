/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

/**
 *
 * Contains information about the discount
 */
public class DiscountDTO {

    private double totalCostDiscount;
    private double itemDiscount;
    private double customerDiscount;

    public DiscountDTO(double totalCostDiscount, double itemDiscount, double customerDiscount){
        this.totalCostDiscount = totalCostDiscount;
        this.itemDiscount = itemDiscount;
        this.customerDiscount = customerDiscount; 

    }

    public DiscountDTO(DiscountDTO discount){
        this.totalCostDiscount = discount.totalCostDiscount;
        this.itemDiscount = discount.itemDiscount;
        this.customerDiscount = discount.customerDiscount; 

    }


    public double getTotalCostDiscount(){
        return this.totalCostDiscount;
    }

    public double getItemDiscount(){
        return this.itemDiscount;      
    }
    
    public double getCustomerDiscount(){
        return this.customerDiscount; 
    }
    
    
}
