package se.kth.iv1350.amazingpos.placeholders;

import se.kth.iv1350.amazingpos.model.ItemDTO;


public class PlaceholderDatabase {
    // an array with a bunch of basically item DTOS
   

    public ItemDTO findItemPlaceholderDatabase(int itemIdentifier){
        ItemDTO[] itemsInDataBase = {
            new ItemDTO(1, "Arla laktosfri mjölk",
             150, "Mjölk", 15), 
            new ItemDTO(2, "Extra virgin olive oil",
             200, "Olive oil", 20) };
       
           
        ItemDTO searchedItem = null;
        for(ItemDTO item:  itemsInDataBase){
            if(item.getItemIdentifier() == itemIdentifier){
                searchedItem = item;
            }
        }
        return searchedItem;
    }
}
