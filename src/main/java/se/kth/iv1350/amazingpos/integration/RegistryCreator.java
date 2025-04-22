
package se.kth.iv1350.amazingpos.integration;



/**
 * Creator which creates the external systems like accounting system and inventory.
 * 
 */
public class RegistryCreator {

    private DiscountDataBase discountDataBase;
    private ExternalAccountingSystem externalAccountingSystem;
    private ExternalInventorySystem externalInventorySystem;

    public RegistryCreator(){

     discountDataBase = new DiscountDataBase();
     externalAccountingSystem = new ExternalAccountingSystem();
     externalInventorySystem = new ExternalInventorySystem();

    } 

    public DiscountDataBase getDiscountDataBase() {
        return discountDataBase;
    }

    public ExternalAccountingSystem getExternalAccountingSystem() {
        return externalAccountingSystem;
    }

    public ExternalInventorySystem getExternalInventorySystem() {
        return externalInventorySystem;
    }
}
