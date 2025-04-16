
package se.kth.iv1350.amazingpos.integration;



/**
 * Creator which creates the external systems like accounting system and inventory.
 * 
 */
public class RegistryCreator {

    DiscountDataBase discountDataBase = new DiscountDataBase();
    ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
    ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
    
}
