
package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.model.*;

/**
 * This is a placeholder for the real view 
 * All inputs to the system are handled via view.It contains hard-coded execution
 * with calls to all system operations in controller.
 * 
 */
public class View {
    private Controller contr;


    private int validItemIdentifier1 = 1;
    private int validItemIdentifier2 = 2;
    private int validItemIdentifier3 = 3;
    private int  quantity = 1;

    private double paidAmount = 1000;


    /**
     * Creates a new instance which uses the specified controller for all calls to other layers
     * @param contr The controller used for all calls to other layers
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Performs a fake sale, by calling all system operations in controller, as we do not have any real view implementation.
     */
    public void runFakeExecution(){


        contr.startSale();
        System.out.println("   **A new sale has been started** ");
        System.out.println("");

        SaleDTO currentSale;

        for(int i = 1; i <= 3; i++){
            currentSale =  contr.addItem(i, quantity);
            ItemDTO currentItem =  currentSale.getLastRegisteredItem();
            System.out.println("Item ID: " + i);
            System.out.println("Item name: " + currentItem.getName()); 
            System.out.println("Item cost: " + currentItem.getPrice() + " SEK"); 
            System.out.println("VAT : " + currentItem.getVatRate()*100 + "%"); 
            System.out.println("Item description: " + currentItem.getItemDescription());
            System.out.println(""); 
            System.out.println("Running total: " + currentSale.getRunningTotal() + " SEK");
            System.out.println("Total VAT: " + currentSale.getTotalVat() + " SEK"); 

            System.out.println(""); 
            System.out.println(""); 

        }
        
        currentSale = contr.addItem(27, 2);
        

        System.out.println(""); System.out.println("");System.out.println("");
         
        double amountToPay = contr.concludeSale();
        System.out.println("Amount to pay: " +  amountToPay);

        System.out.println("--------------Beginning of receipt-------------------"); 
        double change = contr.pay(paidAmount);
        System.out.println("--------------End of receipt-------------------"); 

        System.out.println(""); System.out.println(""); System.out.println(""); 

        System.out.println("Change to give customer: " +  change);
        






        


    }
}
