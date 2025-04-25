package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.amazingpos.model.ItemDTO;

public class ExternalInventorySystemTest {
    private int invalidItemIdentifier = 3;
    private int validItemIdentifier = 2;
    static ExternalInventorySystem exInventory;

    @BeforeAll
    static void setUpClass(){
        exInventory = new ExternalInventorySystem(); 
    }


    
    @AfterAll
    static void tearDownClass() {
        exInventory = null;
        
        
    }
    
    @BeforeEach
    void setUp() {
        
    
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    void  testLookupItemItemDTOIsReturned(){
        ItemDTO item = exInventory.lookupItem(2);
        assertTrue(item instanceof ItemDTO);

    }

    @Test
    void testLookupItemCorrectItemNameReturnedForASpecificItemIdentifier(){
        String expectedResult = "Mjölk";
        ItemDTO itemDTO = exInventory.lookupItem(1);
        assertTrue(itemDTO.getName().equals(expectedResult), "Wrong name returned for the specified item!");

    }



    @Test
    void testLookupInvalidItemIdentifier() {  
        ItemDTO itemDTO = exInventory.lookupItem(5);
        ItemDTO expectedResult = null;
        assertEquals(itemDTO, expectedResult, "Valid itemidentifier not found!");
    }

    @Test
    void testLookupValidItemIdentifier() {
        ItemDTO itemDTO = exInventory.lookupItem(2);
        int expectedResult = 2;
        assertEquals(itemDTO.getItemIdentifier(), expectedResult, "Valid itemidentifier not found!");
    }

   

}

