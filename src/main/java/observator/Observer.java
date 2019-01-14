package observator;

class Observer {
    
    private int lastKnownState = -1;
    
    void update(int newState) {
        lastKnownState = newState;
    }
    
    int getObservedObjectState() {
        return lastKnownState;
    }
}
