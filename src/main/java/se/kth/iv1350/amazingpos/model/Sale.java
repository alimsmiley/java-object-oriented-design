package se.kth.iv1350.amazingpos.model;

import java.util.*;

import java.time.LocalTime;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.*;


/**
 * One single sale made by one single customer and paid with one payment. 
 */
public class Sale {
    private ShoppingList shoppingCart;
    private int runningTotal;
    private LocalTime saleTime;
    private int vat;
    
    private int finalAmount;
    private Receipt receipt;
    private Sale paidSale;
    
            
    /**
     * Creates a new instance of sale 
     *
     */
    public Sale(){
        //shoppingCart = new LinkedList<Node>();
        Sale paidSale = new Sale();
        Printer printer = new Printer();
        Receipt receipt = new Receipt(paidSale, printer);
        
    }
    public SaleDTO registerItem(int itemIdentifier, int quantity){
        ItemDTO item = ExternalAccountingSystem.getItem(itemIdentifier);
        SaleDTO currentSale = new SaleDTO();
       //currentSale.lastRegisteredItem = item;
        return currentSale;
    }
}
