package command;

class MagicAttack extends Command {
    
    @Override
    void execute(Target target) {
        super.execute(target);
        target.attack(15, AttackType.MAGIC);
    }
    
    @Override
    void redoExecute(Target target) {
        execute(target);
    }
    
    @Override
    void undoExecute(Target target) {
        target.attack(-15, AttackType.MAGIC);
    }
    
}
