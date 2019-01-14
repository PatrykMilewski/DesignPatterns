package facade.implementation;

import java.util.HashMap;
import java.util.Map;

class PriceService  {
    
    private Map<String, Double> pricesList = new HashMap<>();
    
    void addPrice(String item, double price) {
        pricesList.put(item, price);
    }
    
    double getPrice(String item) {
        if (pricesList.containsKey(item)) {
            return pricesList.get(item);
        }
        else {
            throw new IllegalArgumentException("Price not found for this item, cannot get price for it.");
        }
    }
    
    
    void deletePrice(String item) {
        if (pricesList.containsKey(item)) {
            pricesList.remove(item);
        }
        else {
            throw new IllegalArgumentException("Price not found for this item, cannot delete it.");
        }
    }
    
    void updatePrice(String item, double newPrice) {
        if (pricesList.containsKey(item)) {
            pricesList.replace(item, newPrice);
        }
        else {
            throw new IllegalArgumentException("Price not found for this item, cannot update it.");
        }
    }
}
