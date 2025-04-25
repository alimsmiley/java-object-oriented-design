
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.CashRegister;

/**
 * Creator which creates the external systems like accounting system and inventory.
 * 
 */
public class RegistryCreator {

    private DiscountDataBase discountDataBase;
    private ExternalAccountingSystem externalAccountingSystem;
    private ExternalInventorySystem externalInventorySystem;
    private CashRegister cashRegister;

    public RegistryCreator(){

        discountDataBase = new DiscountDataBase();
        externalAccountingSystem = new ExternalAccountingSystem();
        externalInventorySystem = new ExternalInventorySystem();
        cashRegister =  new CashRegister();

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

    public CashRegister getCashRegister() {
        return cashRegister;
    }
}
