
package se.kth.iv1350.amazingpos.controller;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.SaleDTO;
/**
 * This is the applications only controller
 * 
 */
public class Controller {
    private Sale sale;
    /**
     * Starts a new sale
     * This method should be called first before doing anything else 
     */
    public void startSale(){
        sale = new Sale();
        
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

        return currentSale;
    }
} //push igen