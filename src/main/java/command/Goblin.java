package command;

class Goblin extends Target {
    
    protected double magicDefense = 0.9;
    
    Goblin() {
        this.health = 10;
    }
    
    @Override
    int attack(int power, AttackType type) {
        int previousHealth = health;
        switch (type) {
            case MAGIC: health -= (int)(magicDefense * power); break;
            default: health -= power; break;
        }
        return previousHealth - health;
    }
    
}
