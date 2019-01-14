package observator;

import java.util.ArrayList;
import java.util.List;

class Observator {
    
    private ObjectThatChangesState objectThatChangesState;
    
    private List<Observer> observersList = new ArrayList<>();
    private int lastKnownState = -1;
    
    Observator(ObjectThatChangesState objectThatChangesState) {
        this.objectThatChangesState = objectThatChangesState;
    }
    
    void addObserver(Observer observer) {
        observersList.add(observer);
    }
    
    void check() {
        int newState = objectThatChangesState.getState();
        if (newState != lastKnownState) {
            lastKnownState = newState;
            observersList.forEach(observer -> observer.update(newState));
        }
    }
}
