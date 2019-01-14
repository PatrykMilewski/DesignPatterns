package composite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Backpack extends Item {
    
    private String description = "Backpack";
    
    private List<Item> items = new ArrayList<Item>(28);
    private double capacity;
    
    public Backpack(double capacity) {
        this.capacity = capacity;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getWeight() {
        return items.stream().mapToDouble(Item::getWeight).sum();
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    boolean addItem(Item newItem) {
        if (newItem.getWeight() + this.getWeight() <= this.capacity)
            return items.add(newItem);
        else
            return false;
    }
    
    String getDescription(int index) {
        if (index < items.size())
            return items.get(index).getDescription();
        else
            throw new ArrayIndexOutOfBoundsException();
    }
}
