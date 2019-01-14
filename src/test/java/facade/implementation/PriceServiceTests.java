package facade.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceServiceTests {
    
    @Test
    void AddingNewItemsWorks() {
        PriceService priceService = new PriceService();
        Item item = new Item("Egg", 0.1);
        
        priceService.addPrice(item.getName(), 1.0);
        assertEquals(1.0, priceService.getPrice(item.getName()));
    }
    
    @Test
    void UpdatingItemsPriceWorks() {
        PriceService priceService = new PriceService();
        Item item = new Item("Egg", 0.1);
        
        priceService.addPrice(item.getName(), 1.0);
        priceService.updatePrice(item.getName(), 2.0);
        assertEquals(2.0, priceService.getPrice(item.getName()));
    }
    
    @Test
    void RemovingItemsPriceWorks() {
        PriceService priceService = new PriceService();
        Item item = new Item("Egg", 0.1);
    
        priceService.addPrice(item.getName(), 1.0);
        priceService.deletePrice(item.getName());
        assertThrows(IllegalArgumentException.class, () -> {
           priceService.getPrice(item.getName());
        });
    }
}
