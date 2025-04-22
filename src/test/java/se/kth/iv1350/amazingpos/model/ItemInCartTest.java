package se.kth.iv1350.amazingpos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemInCartTest {
    
    private int itemIdentifier = 10;
    private String itemDescription = "Jordgubbsglass, GB Gräddglass 5L ";
    private double price = 99.99;
    private String name = "Jordgubbsglass";
    private int vatRate = 15;
    private int quantity = 7;
    ShoppingList shoppingList;
    ItemDTO item;
    ItemInCart itemInCart;


    @BeforeEach
    void setUp() {
        item = new ItemDTO(itemIdentifier, itemDescription, price, name, vatRate);
        itemInCart = new ItemInCart(item, 1);
    }
    @AfterEach
    void tearDown(){
        item = null;
        itemInCart = null;
    }

    @Test
    void testAddQuantity() {
        itemInCart.addQuantity(quantity);

        int expectedresult = 8;
        int result = itemInCart.getQuantity();

        assertEquals(expectedresult, result, "Quantity not updated properly");
    }
}
