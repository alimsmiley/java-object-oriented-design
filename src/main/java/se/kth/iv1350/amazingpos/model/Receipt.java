
package se.kth.iv1350.amazingpos.model;
import se.kth.iv1350.amazingpos.integration.Printer;

/**
 * Represents one receipt, which proves the payment of one sale. 
 */
public class Receipt {
    public Sale paidSale;
    public Printer printer;
    
    /**
     * Creates a new receipt.  
     * @param paidSale 
     * @param printer 
     */
    public Receipt(Sale paidSale, Printer printer){
        this.paidSale = paidSale;
        this.printer = printer;
    }
    
}
