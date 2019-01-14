package facade.implementation;

import lombok.extern.java.Log;

import java.util.List;

@Log
public class ShopFascade {
    
    private PriceService priceService = new PriceService();
    private WarehouseService warehouseService = new WarehouseService(100.0);

    {
        warehouseService.addItem(new DeliveryService("Milk", 1.0), 50);
        warehouseService.addItem(new DeliveryService("Egg", 0.1), 100);
        warehouseService.addItem(new DeliveryService("Bread", 0.5), 10);
        
        priceService.addPrice("Milk", 2.3);
        priceService.addPrice("Egg", 0.5);
        priceService.addPrice("Bread", 3.0);
    }
    
    public double getItemsPrice(String item, int amount) {
        return priceService.getPrice(item) * amount;
    }
    
    public List<Item> buyItems(String item, int amount) {
        double itemsPrice = priceService.getPrice(item) * amount;
        log.info("Selling " + amount + " " + item + " for price " + itemsPrice);
        
        return warehouseService.getItems(item, amount);
    }
    
    public Item buyMilk() {
        double price = priceService.getPrice("Milk");
        log.info("Selling Milk for price " + price);
        
        return warehouseService.getItem("Milk");
    }
}
