package command;

import lombok.Getter;

abstract class Target {
    
    @Getter
    int health;
    
    abstract int attack(int power, AttackType type);
    
}
