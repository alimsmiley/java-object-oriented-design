
package se.kth.iv1350.amazingpos.startup;
import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;
import se.kth.iv1350.amazingpos.view.View;

/**
 * Starts the entire program. Contains main method required to start the application.
 * 
 */
public class Main {
    /**
     * The main method required to start the application
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args){
        
        
      
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();

        Controller contr = new Controller(registryCreator, printer);
        View view = new View(contr);


        view.runFakeExecution(); 
    }
}
