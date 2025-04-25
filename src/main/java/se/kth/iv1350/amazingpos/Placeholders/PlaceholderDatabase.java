package se.kth.iv1350.amazingpos.placeholders;
import se.kth.iv1350.amazingpos.model.*;


/*
 * Placeholder that gets called instead of real external systems.
 */
public class PlaceholderDatabase {
    // an array with a bunch of basically item DTOS
   

    public static ItemDTO findItemPlaceholderDatabase(int itemIdentifier){
        ItemDTO[] itemsInDataBase = {
            new ItemDTO(1, "Arla laktosfri mjölk",
             150, "Mjölk", 0.15), 
            new ItemDTO(2, "Extra virgin olive oil",
             200, "Olive oil", 0.20), 
            new ItemDTO(3, "Messsmör original 5%",30, "Messmör", 0.25) };

       
           
        ItemDTO searchedItem = null;
        for(ItemDTO item:  itemsInDataBase){
            if(item.getItemIdentifier() == itemIdentifier){
                searchedItem = item;
            }
        }
        return searchedItem;
    }


    public static DiscountDTO findDiscountPlaceHolderDatabase(SaleDTO currentSale, int customerID){
        DiscountDTO[] discounts = {new DiscountDTO(0.10, 0, 0.05),
             new DiscountDTO(0, 0, 0)};
        
        if(customerID == 123){
            return discounts[0];
        }
        return discounts[1];
       
    }
}
