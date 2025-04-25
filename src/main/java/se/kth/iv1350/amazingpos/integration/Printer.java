/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.*;
import java.util.*;

/**
 *
 * Contains the printers functionality
 */
public class Printer {
   

    public void printReceipt(Receipt receipt){
        //Datum + Tid
        System.out.println("Time of sale: " + receipt.getSaleTime());
        itemsToPrint(receipt.getListOfBoughtItems().getShoppingList());
        System.out.println("Total: " + receipt.getFinalAmount());
        //Discount?
        System.out.println("VAT: " + receipt.getVat());
        System.out.println("Paid amount: " + receipt.getAmountPaid());
        System.out.println("Change: " + receipt.getChange());
    }

    private void itemsToPrint(ArrayList<ItemInCart> shoppingCart){
        for (int i = 0; i < shoppingCart.size(); i++){
            System.out.println(shoppingCart.get(i).getItemDTO().getName() + " " 
            + shoppingCart.get(i).getQuantity() + " x " 
            + shoppingCart.get(i).getItemDTO().getPrice() + " " 
            + (shoppingCart.get(i).getItemDTO().getPrice()*shoppingCart.get(i).getQuantity()));
        }
    }
}
