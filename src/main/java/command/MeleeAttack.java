package command;

class MeleeAttack extends Command {
    
    @Override
    void execute(Target target) {
        super.execute(target);
        target.attack(10, AttackType.MELEE);
    }
    
    @Override
    void redoExecute(Target target) {
        execute(target);
    }
    
    @Override
    void undoExecute(Target target) {
        target.attack(-10, AttackType.MELEE);
    }
    
}
