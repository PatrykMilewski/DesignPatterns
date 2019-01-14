package command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandTests {
    
    private Command meleeAttack;
    private Target targetGoblin;
    private int healthBeforeAttack;
    private Wizard wizard;
    
    @BeforeEach
    void initialize() {
        meleeAttack = new MeleeAttack();
        targetGoblin = new Goblin();
        healthBeforeAttack = targetGoblin.getHealth();
        wizard = new Wizard();
    }
    
    @Test
    void MeleeAttackWorks() {
        wizard.interaction(meleeAttack, targetGoblin);
        
        assertTrue(targetGoblin.getHealth() < healthBeforeAttack);
    }
    
    @Test
    void MagicAttackWorks() {
        Command magicAttack = new MagicAttack();
        
        wizard.interaction(magicAttack, targetGoblin);

        assertTrue(targetGoblin.getHealth() < healthBeforeAttack);
    }
    
    @Test
    void CommendRedoWorks() {
        wizard.interaction(meleeAttack, targetGoblin);
        int healthAfterFirstAttack = targetGoblin.getHealth();
        wizard.redoLastInteraction();
    
        assertTrue(targetGoblin.getHealth() < healthAfterFirstAttack);
    }
    
    @Test
    void CommandUndoWorks() {
        wizard.interaction(meleeAttack, targetGoblin);
        wizard.undoLastInteraction();
        
        assertEquals(healthBeforeAttack, targetGoblin.getHealth());
    }
    
}
