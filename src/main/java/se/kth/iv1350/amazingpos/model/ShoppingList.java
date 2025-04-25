package se.kth.iv1350.amazingpos.model;

import java.util.*;

/**
 * Represents the list of items in a specific sale.
 */
public class ShoppingList {
    private ArrayList<ItemInCart> shoppingList;

    /**
     * Creates an instance of the shopping list.
     */
    public ShoppingList() {
        this.shoppingList = new ArrayList<>();
    }

    /**
     * Overloaded constructor for shopping list given {@link original} to create a copy
     * @param original The original Shopping list.
     */
    public ShoppingList(ShoppingList original) {
        this.shoppingList = new ArrayList<>();
        for (ItemInCart item : original.shoppingList) {
            this.shoppingList.add(new ItemInCart(item.getItemDTO(), item.getQuantity()));
        }
    }

    /**
     * Adds an {@link item} to the shopping list with a given {@link quantity}.
     * @param item     The item to be added.
     * @param quantity The quantity of the item.
     */
    public void addToShoppingList(ItemDTO item, int quantity) {

        int positionInShoppingList = searchForItem(item);
        if (positionInShoppingList == -1) {
            ItemInCart itemForCart = new ItemInCart(item, quantity);
            shoppingList.add(itemForCart);
        } else {
            shoppingList.get(positionInShoppingList).addQuantity(quantity);
        }

    }

    /**
     * Searches to see if an {@link item} exsists in the list already.
     * @param item The item that is searched for.
     * @return The possition of the found item.
     */
    private int searchForItem(ItemDTO item) {
        int possition = -1;
        int searchID = item.getItemIdentifier();
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).getItemDTO().getItemIdentifier() == searchID) {
                possition = i;
                return possition;
            }
        }
        return possition;
    }

    public ArrayList<ItemInCart> getShoppingList() {
        return this.shoppingList;

    }
}
