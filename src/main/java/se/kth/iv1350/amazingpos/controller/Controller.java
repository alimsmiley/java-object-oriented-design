
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
    
    public SaleDTO addItem(int itemIdentifier, int quantity){
        SaleDTO currentSale = sale.registerItem(itemIdentifier, quantity);

        return currentSale;
    }
} //push igen