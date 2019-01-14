package facade.implementation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarehouseServiceTests {
    
    @Test
    void AddingItemsToWarehouseWorksCorrectly() {
        WarehouseService warehouseService = new WarehouseService(100.0);
        
        double totalWeight = (0.1 * 100) + (1.0 * 50) + (0.5 * 30);
        int totalAmount = 100 + 50 + 30;
        DeliveryService deliveryService = new DeliveryService("Egg", 0.1);
        
        warehouseService.addItem(deliveryService, 100);
        warehouseService.addItem(new DeliveryService("Milk", 1.0), 49);
        warehouseService.addItem(new DeliveryService("Milk", 1.0), 1);
        warehouseService.addItem(new DeliveryService("Bread", 0.5), 30);
        
        assertEquals(totalWeight, warehouseService.getStoredItemsWeight(), 0.001);
        assertEquals(totalAmount, warehouseService.getTotalItemsAmount());
        assertTrue(deliveryService.itemEquals(warehouseService.getItem("Egg")));
        assertThrows(IllegalArgumentException.class, () -> {
            warehouseService.getItem("Not existing item");
        });
    }
    
    @Test
    void RemovingItemsFromWarehouseWorksCorrectly() {
        WarehouseService warehouseService = new WarehouseService(100.0);
        double milkWeight = 1.0 * 10;
        warehouseService.addItem(new DeliveryService("Egg", 0.1), 10);
        warehouseService.addItem(new DeliveryService("Milk", 1), 10);
        List<Item> eggs = warehouseService.getItems("Egg", 10);
        
        assertEquals(eggs.size(), 10);
        assertEquals(milkWeight, warehouseService.getStoredItemsWeight());
    }
    
    @Test
    void AddingItemsExceedingMaximumCapacityThrowsException() {
        WarehouseService warehouseService = new WarehouseService(100.0);
        warehouseService.addItem(new DeliveryService("Milk", 1.0), 100);
        assertThrows(IllegalArgumentException.class, () -> {
            warehouseService.addItem(new DeliveryService("Milk", 1.0), 1);
        });
    }
    
}
