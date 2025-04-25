
package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.ItemDTO;
import se.kth.iv1350.amazingpos.model.SaleDTO;
import se.kth.iv1350.amazingpos.placeholders.PlaceholderDatabase;


/**
 *
 * Includes a database of information about all items
 */
public class ExternalInventorySystem {
    
    /**
     * Gets the item information from an external inventroy system given the {@link itemIdentifier} and returns the item found.
     * @param itemIdentifier The item identifier.
     * @return The item that was looked up.
     */
    public ItemDTO lookupItem(int itemIdentifier){
        ItemDTO item;
        // sends a request to the external database that either doesnt return anything usefull or returns the data so we can create a ItemDTO
        ItemDTO placeholderDTO = PlaceholderDatabase.findItemPlaceholderDatabase(itemIdentifier);
        if(placeholderDTO == null){
            item = null;
            return item;
        }
        else{
            item = new ItemDTO(placeholderDTO);
        }
        return item;
    }



    /**
     * Takes a {@link paidSale} and sends it to an external system to update said system.
     * @param paidSale The final sale data.
     */
    public void updateExternalInventorySystem(SaleDTO paidSale){
        
    } 
}




