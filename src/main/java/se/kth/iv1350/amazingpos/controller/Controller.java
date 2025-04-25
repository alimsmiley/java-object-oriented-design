
package se.kth.iv1350.amazingpos.controller;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;
import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.SaleDTO;


/**
 * This is the applications only controller
 * 
 */
public class Controller {
    private Sale sale;
    private RegistryCreator externalSystems;
    private Printer printer;

    public static final int MAX_ALLOWED_QUANTITY = 1000;

    /**
     * Creates an instance of controller.
     * @param creator   The regisrty creator.
     * @param printer   The printer.
     */
    public Controller(RegistryCreator creator, Printer printer){
       this.externalSystems = creator;
       this.printer = printer;  
    }

    /**
     * Checks to see if the {@link quantity} is a resonable amount.
     * @param quantity The given quantity of items.
     * @return  If resonable or not.
     */
    public boolean isQuantityReasonable(int quantity){
        if(quantity > MAX_ALLOWED_QUANTITY || quantity < 0){
            return false;
        }
        return true;
    }

    /**
     * Starts a new sale
     * This method should be called first before doing anything else 
     */
    public void startSale(){    
        this.sale = new Sale(externalSystems, printer);
    }

    /**
     * This method adds a specified {@link quantity} of an item to the current sale.
     * 
     * @param itemIdentifier The number that corresponds to the item added.
     * @param quantity  The quantity of the item that are to be added.
     * @return The current sale dto.
     */
    public SaleDTO addItem(int itemIdentifier, int quantity){
        
        if(!isQuantityReasonable(quantity)){
            //should throw an exception 
            System.out.println("Invalid item quantity!");
            return null;           
        }

        SaleDTO currentSale = sale.registerItem(itemIdentifier, quantity);
        currentSale.checkItemValidity(); //should throw an exception if invalid!
        return currentSale;  
    }

    /**
     * Sends a request to the program to check if the customer is eligible for discounts.
     * @param customerID unique int assigned to customer for identification
     * @return Returns a SaleDTO with runningTotal updated with the discount if the customer is eligible
     *         if not eligible, the runningTotal remains unchanged.
     */
    public SaleDTO signalDiscount(int customerID){
        SaleDTO currentSale = sale.checkForDiscount(customerID);

        return currentSale;
    }

    /**
     * Fetches the final amount that is to be paid by the customer.
     * @return the final amount to be paid.
     */
    public double concludeSale(){
        double finalAmount = sale.endSale();

        return finalAmount;

    }

    /**
     * The process of the payment given {@link paidAmount}, also updates the external systems with the same information.
     * @param paidAmount    The amount paid for the sale.
     * @return  The change to be given back.
     */
    public double pay(double paidAmount){
        Payment payment = new Payment(paidAmount);
        double change = sale.pay(payment);
        sale.printReceipt(paidAmount, change);

        //As the view is not designed in this assigment:
        //if the change is negative, the view will call the pay method again (until the remaining amount is zero) for the remaining amount to be paid
        
        externalSystems.getCashRegister().updateCashRegister(payment);
       
        return change;

    }

    






} 