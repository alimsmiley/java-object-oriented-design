package se.kth.iv1350.amazingpos.model;

import java.time.LocalTime;

import se.kth.iv1350.amazingpos.integration.*;





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
    private RegistryCreator externalSystems;
    private Printer printer;
    //private Sale paidSale;     Vad ska denna användas till?
    
            
    /**
     * Creates a new instance of sale 
     *
     */
    public Sale(RegistryCreator exSystems, Printer printer){
        shoppingCart = new ShoppingList();
        this.externalSystems = exSystems;
        this.printer = printer;
        this.saleTime = LocalTime.now();

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
            shoppingCart.addToShoppingList(item, quantity);

        }
        return currentSale; 
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


