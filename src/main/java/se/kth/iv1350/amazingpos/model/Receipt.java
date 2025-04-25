
package se.kth.iv1350.amazingpos.model;
import se.kth.iv1350.amazingpos.integration.Printer;

/**
 * Represents one receipt, which proves the payment of one sale. 
 */
public class Receipt {
    public Sale paidSale;
    public Printer printer;
    
    /**
     * Creates a new instance of receipt with a {@link paidSale} that uses a {@link printer}.
     * @param paidSale The sale that has been paid for.
     * @param printer The printer to be used for printing.
     */
    public Receipt(Sale paidSale, Printer printer){
        this.paidSale = paidSale;
        this.printer = printer;
    }
    
}
