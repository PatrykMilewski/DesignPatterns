package observator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservatorTests {
    
    @Test
    void ObservatorsGetsUpdatesFromObservers() {
        ObjectThatChangesState objectThatChangesState = new ObjectThatChangesState();
        
        Observator observator = new Observator(objectThatChangesState);
        Observer observerFirst = new Observer();
        Observer observerSecond = new Observer();
        
        observator.addObserver(observerFirst);
        observator.addObserver(observerSecond);
    
        assertEquals(-1, observerFirst.getObservedObjectState());
        assertEquals(-1, observerSecond.getObservedObjectState());
    
        objectThatChangesState.setState(100);
        
        observator.check();
        
        assertEquals(100, observerFirst.getObservedObjectState());
        assertEquals(100, observerSecond.getObservedObjectState());
    }
    
}
