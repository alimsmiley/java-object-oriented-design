/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

/**
 *  Represents the cash register.
 * 
 */
public class CashRegister {
    private double balance;


    public CashRegister(){
        this.balance = 5000;
    }


    


    public void updateCashRegister(Payment payment){
        this.balance += payment.getPaidAmount() - payment.getChange();

    }

    public double getBalance(){
        return this.balance;
    }



}
