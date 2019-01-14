package command;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

abstract class Command {
    
    protected List<Pair<Command, Target>> commandHistory = new ArrayList<>();
    
    void execute(Target target) {
        commandHistory.add(new Pair<>(this, target));
    }
    
    void redo() {
        Pair<Command, Target> fromHistory = getLastCommand();
        Command command = fromHistory.getKey();
        Target target = fromHistory.getValue();
        command.redoExecute(target);
    }
    
    abstract void redoExecute(Target target);
    
    void undo() {
        Pair<Command, Target> fromHistory = getLastCommand();
        commandHistory.remove(fromHistory);
        Command command = fromHistory.getKey();
        Target target = fromHistory.getValue();
        command.undoExecute(target);
    }
    
    abstract void undoExecute(Target target);
    
    private Pair<Command, Target> getLastCommand() {
        return commandHistory.get(commandHistory.size() - 1);
    }
    
}
