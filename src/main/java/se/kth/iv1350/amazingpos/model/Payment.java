/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

/**
 *
 * Represents a payment made for a single specific sale.
 */
public class Payment {
    private double paidAmount;
    private double change;

    public Payment(double paidAmount){
        this.paidAmount = paidAmount;
    }

    double getPaidAmount(){
        return this.paidAmount;
    }

    double getChange(){
        return this.change;
    }

    void calculateTotalAmount(Sale paidSale){
        
        this.change = this.paidAmount - paidSale.getRunningTotal();
    }
}
