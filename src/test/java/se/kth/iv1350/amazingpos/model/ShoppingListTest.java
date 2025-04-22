package se.kth.iv1350.amazingpos.model;


import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class ShoppingListTest {
    private int itemIdentifier = 3;
    private String itemDescription = "Medelhavs salt med jod";
    private double price = 25.99;
    private String name = "Salt";
    private int vatRate = 15;
    private int quantity = 1;
    ShoppingList shoppingList;
    ItemDTO item;

/* 
    @BeforeAll
    public void setUpClass(){
        shoppingList = new ShoppingList();
    }
        

    @AfterAll
    public static void tearDownClass() {
        
        
    }
    */

    @BeforeEach
    public  void setUp() {
        shoppingList = new ShoppingList();
        item = new ItemDTO(itemIdentifier, itemDescription, price, name, vatRate);
        shoppingList.addToShoppingList(item, quantity );
    
    }


    @Test
    public void testIfItemAddedToShoppingList() {
        
    
        ArrayList<ItemInCart> shopList = shoppingList.getShoppingList();
        boolean found = false;
        for(ItemInCart itemInCart: shopList){
            if(itemInCart.getItemDTO().getItemIdentifier() == item.getItemIdentifier()){
                found = true;
                break;

            }

        }
        
        assertTrue(found, "Item failed to be added");

    }
}
