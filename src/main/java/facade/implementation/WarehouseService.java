package facade.implementation;

import java.util.*;

class WarehouseService {
    
    private final double capacity;
    
    private Map<String, List<Item>> items = new HashMap<>();
    
    WarehouseService(double capacity) {
        this.capacity = capacity;
    }
    
    void addItem(final DeliveryService deliveryService, int amount) {
        double newItemsWeight = deliveryService.getItemWeight() * amount;
        if (getStoredItemsWeight() + newItemsWeight > capacity)
            throw new IllegalArgumentException("New items weight exceeds maximum capacity.");
        
        if (items.containsKey(deliveryService.getItemName())) {
            List<Item> itemsList = deliveryService.getItems(amount);
            items.get(deliveryService.getItemName()).addAll(itemsList);
        }
        else {
            List<Item> itemsList = deliveryService.getItems(amount);
            items.put(deliveryService.getItemName(), itemsList);
        }
    }
    
    double getStoredItemsWeight() {
        double itemsWeight = 0.0;
        for (Map.Entry<String, List<Item>> entry : items.entrySet()) {
            for (Item item : entry.getValue()) {
                itemsWeight += item.getWeight();
            }
        }
        return itemsWeight;
    }
    
    int getTotalItemsAmount() {
        int itemsAmount = 0;
        for (Map.Entry<String, List<Item>> entry : items.entrySet()) {
            itemsAmount += entry.getValue().size();
        }
        return itemsAmount;
    }
    
    Item getItem(String itemName) {
        if (items.containsKey(itemName)) {
            List<Item> itemsList = items.get(itemName);
            return itemsList.remove(0);
        }
        else
            throw new IllegalArgumentException("Given item does not exists in Warehouse");
    }
    
    List<Item> getItems(String itemName, int amount) {
        if (items.containsKey(itemName)) {
            List<Item> itemsList = items.get(itemName);
            if (itemsList.size() < amount)
                throw new IllegalArgumentException("Requested amount exceeds items on stock amount");
            
            List<Item> resultList = itemsList.subList(0, amount);
            List<Item> leftItems = itemsList.subList(amount, itemsList.size());
            items.replace(itemName, leftItems);
            return resultList;
        }
        else
            throw new IllegalArgumentException("Given item does not exists in Warehouse");
    }
}
