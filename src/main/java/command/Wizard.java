package command;

class Wizard {
    
    private Command lastCommand;
    
    void interaction(Command command, Target target) {
        command.execute(target);
        lastCommand = command;
    }
    
    void redoLastInteraction() {
        lastCommand.redo();
    }
    
    void undoLastInteraction() {
        lastCommand.undo();
    }
    
}
