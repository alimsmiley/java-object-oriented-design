package se.kth.iv1350.amazingpos.model;
import java.util.*;


/**
 * Represents the list of items in a specific sale.
 */
public class ShoppingList {
    private ArrayList<ItemInCart> shoppingList;

    public ShoppingList(){
        this.shoppingList = new ArrayList<ItemInCart>();
    }

    public void addToShoppingList(ItemDTO item, int quantity){
        int positionInShoppingList = searchForItem(item);
        if(positionInShoppingList == -1){
            ItemInCart itemForCart = new ItemInCart(item, quantity);
            shoppingList.add(itemForCart);
        }
        shoppingList.get(positionInShoppingList).addQuantity(quantity);
    }

    private int searchForItem(ItemDTO item){
        int possition = -1;
        int searchID = item.getItemIdentifier();
        for (int i = 0; i < shoppingList.size(); i++){
            if(shoppingList.get(i).getItemDTO().getItemIdentifier() == searchID){
                possition = i;
                return possition;
            }
        }
        return possition;
    }
}
