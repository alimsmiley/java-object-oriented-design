package se.kth.iv1350.amazingpos.model;
import java.util.*;
// Check if needed later
// Want to have it like this to send multiple items into a list in java
/**
 * Represents an certain quantity of items in the sopping cart
 */
public class ItemInCart {
    private ItemDTO item;
    private int quantity;

    /**
     * Creates a new instance of {@link item} in cart with a certain {@link quantity}.
     * @param item The item DTO of the item added.
     * @param quantity The quantity of items.
     */
    public ItemInCart(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    /**
     * Gets the quantity of the item.
     * @return The quantity.
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Gets the item dto of the item in the cart.
     * @return The item dto.
     */
    public ItemDTO getItemDTO(){
        return this.item;
    }
    /**
     * Adds {@link quantity} of the item in the cart.
     * @param quantity The quantity to add.
     */
    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

}
