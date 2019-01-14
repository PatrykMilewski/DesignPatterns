package facade.implementation;

import java.util.ArrayList;
import java.util.List;

class DeliveryService {
    
    private final String itemName;
    
    private final double itemWeight;
    DeliveryService(String itemName, double itemWeight) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }
    
    Item getItem() {
        return new Item(itemName, itemWeight);
    }
    
    String getItemName() {
        return itemName;
    }
    
    double getItemWeight() {
        return itemWeight;
    }
    
    boolean itemEquals(Item item) {
        return item.getName().equals(itemName) && item.getWeight() == itemWeight;
    }
    
    List<Item> getItems(int amount) {
        List<Item> items = new ArrayList<>(amount);
        
        while (amount > 0) {
            items.add(new Item(itemName, itemWeight));
            amount--;
        }
        
        return items;
    }
}
