package se.kth.iv1350.amazingpos.model;

import java.time.LocalTime;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.integration.*;





/**
 * One single sale made by one single customer and paid with one payment. 
 */
public class Sale {
    private ShoppingList shoppingCart;
    private double runningTotal;
    private LocalTime saleTime;
    private double vat;
    private double finalAmount;
    private Receipt receipt;
    private RegistryCreator externalSystems;
    private Printer printer;
    //private Sale paidSale;     Vad ska denna användas till?
    
            
    /**
     * Creates a new instance of sale 
     *
     */
    public Sale(RegistryCreator exSystems, Printer printer){
        this.shoppingCart = new ShoppingList();
        this.externalSystems = exSystems;
        this.printer = printer;
        this.saleTime = LocalTime.now();
        this.vat = 0;
        this.finalAmount = 0;
        this.runningTotal = 0;

    }

    /**
     * Registers an item to be purchased.
     * @param itemIdentifier The identifier for each item represented as an integer.
     * @param quantity Number of Items to be registered.
     * @return An object  containing all indormation about an item.
     */
    public SaleDTO registerItem(int itemIdentifier, int quantity){


        ItemDTO item = externalSystems.getExternalInventorySystem().lookupItem(itemIdentifier);
        SaleDTO currentSale = new SaleDTO(this, item);

        if(item != null){
            updateShoppingCart(item, quantity);
            updateRunningTotal(item, quantity);
        }
        return currentSale; 
    }
    /**
     * checks for discount and if customer is eligible it applies the rate of discount on the runningTotal and updates the price.
     * @param customerID unique int assigned to customer for identification
     * @return Returns a SaleDTO with runningTotal updated with the discount if the customer is eligible
     *         if not eligible, the runningTotal remains unchanged.
     */
    public SaleDTO checkForDiscount(int customerID){ 
        SaleDTO currentSale = new SaleDTO(this);
        DiscountDTO totalDiscount = externalSystems.getDiscountDataBase().searchForDiscount(currentSale, customerID);
        applyDiscount(totalDiscount);
        SaleDTO updatedSale = new SaleDTO(this); 

        return updatedSale;

    }

    /**
     * ends the sales process
     * @return The final amount to be paid
     */
    public double endSale(){
        this.finalAmount = runningTotal;
        return finalAmount;
    }

    /**
     * Applies the discount to the sales runningTotal
     * @param totalDiscount the total percentage of discount the customer is eligible for
     */
    private void applyDiscount(DiscountDTO totalDiscount){
        double appliedDiscount = calculateDiscount(totalDiscount);
        
        double finalPriceAfterDiscount = this.runningTotal - this.runningTotal*appliedDiscount;
        this.runningTotal = finalPriceAfterDiscount;

    }
    /**
     * Calculates the total percentage of the accumalated discounts.
     * @param totalDiscount
     * @return
     */
    private double calculateDiscount(DiscountDTO totalDiscount){
        double calculatedDiscount = totalDiscount.getItemDiscount() + totalDiscount.getCustomerDiscount() + totalDiscount.getTotalCostDiscount();

        return calculatedDiscount;
    }

    /**
     * Adds a specified quantity of an item to the ShoppingCart.
     * @param item Item to be added to the ShoppingCart.
     * @param quantity 
     */
    private void updateShoppingCart(ItemDTO item, int quantity){
        shoppingCart.addToShoppingList(item, quantity);
    }
    /**
     * Calculates and updates the RunningTotal of the Sale.
     * @param item Item to be bought
     * @param quantity Quantity of the item to be bought
     */
    private void updateRunningTotal(ItemDTO item, int quantity){

        double vatToPayItem = updateVat(item, quantity);
        double totalItemPrice = item.getPrice()*quantity + vatToPayItem;
        
        runningTotal += totalItemPrice;
    }
    

    /**
     * Calculates and updates the total vat to be paid for the sale
     * and for each item.
     * @param item Item for which the vat is to be calculated
     * @param quantity Quantity of the item
     * @return Returns the amount of vat to be paid for an item 
     * multiplied with the quantity. 
     */
    private double updateVat(ItemDTO item, int quantity){
        double vatToPayForItem = item.getPrice()*quantity*item.getVatRate();
        vat += vatToPayForItem;
        return vatToPayForItem;
    }

    public ShoppingList getShoppingCart(){
        return shoppingCart;
    }

    public double getRunningTotal(){
        return runningTotal;
    }

    public LocalTime getSaleTime(){
        return saleTime;
    }
    
    public double getVat(){
        return vat;
    }

    public double getFinalAmount(){
        return finalAmount;
    }

    public Receipt getReceipt(){
        return receipt;
    }

}


