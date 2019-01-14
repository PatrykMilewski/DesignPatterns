package composite;

class Sword extends Item {
    
    private final String description = "Mithril sword";
    private final double weight = 10.0;
    
    @Override
    String getDescription() {
        return description;
    }
    
    @Override
    double getWeight() {
        return weight;
    }
    
}
