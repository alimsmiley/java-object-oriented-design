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

    /**
     * Creates a new instance of payment.
     * @param paidAmount    The amount that has been paid.
     */
    public Payment(double paidAmount){
        this.paidAmount = paidAmount;
        //this.change = change;
    }

    /**
     * Calculates the change to get back.
     * @param paidSale  The sale that has been paid for.
     */
    public void calculateChange(Sale paidSale){
        //Negative change if paidAmount < finalAmount  -> add error message, should pay more
        this.change = this.paidAmount - paidSale.getFinalAmount() ;

    }

    public double getChange(){
        return this.change;
    }

    public double getPaidAmount(){
        return this.paidAmount;
    }

}
