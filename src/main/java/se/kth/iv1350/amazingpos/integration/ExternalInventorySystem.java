/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.ItemDTO;
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
    public static ItemDTO lookupItem(int itemIdentifier){
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
}




