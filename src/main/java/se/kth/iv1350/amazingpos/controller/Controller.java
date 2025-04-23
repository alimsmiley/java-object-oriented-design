
package se.kth.iv1350.amazingpos.controller;
import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.*;

/**
 * This is the applications only controller
 * 
 */
public class Controller {
    private Sale sale;
    private RegistryCreator externalSystems;
    private Printer printer;

    public Controller(RegistryCreator creator, Printer printer){
       this.externalSystems = creator;
       this.printer = printer;
    }



    /**
     * Starts a new sale
     * This method should be called first before doing anything else 
     */
    public void startSale(){
        sale = new Sale(externalSystems, printer);
        
    }
    /**
     * This method adds a specified {@link quantity} of an item to the current sale.
     * 
     * @param itemIdentifier The number that corresponds to the item added.
     * @param quantity  The quantity of the item that are to be added.
     * @return The current sale dto.
     */
    public SaleDTO addItem(int itemIdentifier, int quantity){
        SaleDTO currentSale = sale.registerItem(itemIdentifier, quantity);
        currentSale.checkItemValidity(); //should throw an exception if invalid!
           
        return currentSale;
        
    }
} 