
package se.kth.iv1350.amazingpos.startup;
import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.view.View;
import se.kth.iv1350.amazingpos.integration.RegistryCreator;
import se.kth.iv1350.amazingpos.integration.Printer;

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
        Controller contr = new Controller();
        
        View view = new View(contr);
        view.runFakeExecution();
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
    }

}
//testar nu
