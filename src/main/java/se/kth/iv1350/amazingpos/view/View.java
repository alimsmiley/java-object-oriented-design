
package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;

/**
 * This is a placeholder for the real view 
 * All inputs to the system are handled via view.It contains hard-coded execution
 * with calls to all system operations in controller.
 * 
 */
public class View {
    private Controller contr;
    
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
        System.out.println("A new sale has been started");
    }
    
    
    
    //Help
}
