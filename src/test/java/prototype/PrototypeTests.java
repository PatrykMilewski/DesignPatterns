package prototype;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrototypeTests {

    @Test
    void CreationOfPrototypeIsConstant() throws CloneNotSupportedException {
        Database databasePrototype = new Database();
        databasePrototype.initializeDictionaries();
        Database firstClone = databasePrototype.clone();
        Database secondClone = databasePrototype.clone();

        assertEquals(databasePrototype, firstClone);
        assertEquals(firstClone, secondClone);
    }
    
}
