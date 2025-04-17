/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.ItemDTO;

/**
 *
 * Includes a database of information about all items
 */
public class ExternalInventorySystem {
    /**
     * Creates an instance of the inventory system
     */
    ExternalInventorySystem(){

    }
    /**
     * Gets the item information form external inventroy system given the
     * @param itemIdentifier
     * @return
     */
    public ItemDTO getItem(int itemIdentifier){
        ItemDTO item;
        // sends a request to the external database that either doesnt return anything usefull or returns the data so we can create a ItemDTO
        ItemDTO placeholderDTO = findItemPlaceholderDatabase(itemIdentifier);
        if(placeholderDTO == null){
            item = null;
            return item;
        }
        else{
            item = new ItemDTO(placeholderDTO.itemIdentifier, placeholderDTO.itemDescription, placeholderDTO.price, placeholderDTO.name, placeholderDTO.vatRate);
        }
        return item;
    }
}
<<<<<<< HEAD

//Vi börjar här
=======
//Last thing done
>>>>>>> 2e1f8ec9d6b6631ba69b5efceee365552a208a83
