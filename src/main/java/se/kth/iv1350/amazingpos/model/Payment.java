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
        //this.change = change;
    }


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
