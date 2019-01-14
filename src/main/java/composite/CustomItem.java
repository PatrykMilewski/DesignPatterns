package composite;

class CustomItem extends Item {
    
    private String description;
    private double weight;
    
    public CustomItem(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }
    
    @Override
    String getDescription() {
        return description;
    }
    
    @Override
    double getWeight() {
        return weight;
    }
}
