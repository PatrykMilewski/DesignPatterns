package composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BackpackTests {
    
    @Test
    void WeightSumWorksCorrectly() {
        Backpack backpack = new Backpack(100.0);
        
        backpack.addItem(new Sword());
        backpack.addItem(new Sword());
        
        assertEquals(new Sword().getWeight() * 2, backpack.getWeight());
    }
    
    @Test
    void MaxCapacityWorksCorrectly() {
        double twoSwordsWeight = new Sword().getWeight() * 2;
        Backpack backpack = new Backpack(twoSwordsWeight);
        
        assertTrue(backpack.addItem(new Sword()));
        assertTrue(backpack.addItem(new Sword()));
        assertFalse(backpack.addItem(new Sword()));
        
        assertEquals(twoSwordsWeight, backpack.getWeight());
    }
    
    @Test
    void ItemsDescriptionWorksCorrectly() {
        Backpack backpack = new Backpack(20.0);
        CustomItem firstItem = new CustomItem("First", 5.0);
        CustomItem secondItem = new CustomItem("Second", 5.0);
        backpack.addItem(firstItem);
        backpack.addItem(secondItem);
    
        assertEquals("First", backpack.getDescription(0));
        assertEquals("Second", backpack.getDescription(1));
    }
    
    @Test
    void GettingDescriptionFromNonExistingItemIndexThrows() {
        Backpack backpack = new Backpack(100.0);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            backpack.getDescription(0);
        });
        
        backpack.addItem(new Sword());
        assertNotNull(backpack.getDescription(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            backpack.getDescription(1);
        });
    }
}
