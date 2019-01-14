package composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomItemTests {
    
    @Test
    void CustomDescriptionEqualsDescriptionGivenToCustomItem() {
        String description = "Test description";
        
        CustomItem customItem = new CustomItem(description, 1.0);
        
        assertEquals(description, customItem.getDescription());
    }
    
    @Test
    void CustomWeightEqualsWeightGivenToCustomItem() {
        double weight = 1.23;
        
        CustomItem customItem = new CustomItem("test", weight);
        
        assertEquals(weight, customItem.getWeight());
    }
    
}
