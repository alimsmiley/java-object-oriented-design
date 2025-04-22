package se.kth.iv1350.amazingpos.model;

import java.time.LocalTime;

import se.kth.iv1350.amazingpos.integration.ExternalInventorySystem;
import se.kth.iv1350.amazingpos.integration.Printer;



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
    //private Sale paidSale;     Vad ska denna användas till?
    
            
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

    /**
     * Registers an item to be purchased.
     * @param itemIdentifier The identifier for each item represented as an integer.
     * @param quantity Number of Items to be registered.
     * @return An object  containing all indormation about an item.
     */
    public SaleDTO registerItem(int itemIdentifier, int quantity){
        ItemDTO item = ExternalInventorySystem.lookupItem(itemIdentifier);
        SaleDTO currentSale = new SaleDTO(this, item);
       //currentSale.lastRegisteredItem = item;
        return currentSale; 
    }

    /**
     * Represents the transactions of {@link payment}.
     * @param payment   The payment.
     * @return  The change.
     */
    public double pay(Payment payment){
        payment.calculateChange(this);
        double change = payment.getChange();
        return change;
    }


    public ShoppingList getShoppingCart(){
        return shoppingCart;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public LocalTime getSaleTime(){
        return saleTime;
    }
    
    public int getVat(){
        return vat;
    }

    public int getFinalAmount(){
        return finalAmount;
    }

    public Receipt getReceipt(){
        return receipt;
    }


}


