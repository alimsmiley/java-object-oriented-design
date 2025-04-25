
package se.kth.iv1350.amazingpos.model;
import java.time.LocalTime;

import se.kth.iv1350.amazingpos.integration.Printer;

/**
 * Represents one receipt, which proves the payment of one sale. 
 */
public class Receipt {
    private LocalTime saleTime;
    private ShoppingList listOfBoughtItems;
    private double finalAmount;
    private double vat;
    private double amountPaid;
    private double change;
    
    /**
     * Creates a new instance of receipt with a {@link paidSale} that uses a {@link printer}.
     * @param paidSale The sale that has been paid for.
     * @param printer The printer to be used for printing.
     */
    public Receipt(Sale paidSale){
        saleTime = paidSale.getSaleTime();
        listOfBoughtItems = paidSale.getShoppingCart();
        finalAmount = paidSale.getFinalAmount();
        vat = paidSale.getVat();
        amountPaid = paidSale.getPayment().getPaidAmount();
        change = paidSale.getPayment().getChange();
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getChange() {
        return change;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public ShoppingList getListOfBoughtItems() {
        return listOfBoughtItems;
    }

    public LocalTime getSaleTime() {
        return saleTime;
    }
    
    public double getVat() {
        return vat;
    }
    
}
