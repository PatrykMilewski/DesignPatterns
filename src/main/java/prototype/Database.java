package prototype;

import java.util.HashMap;
import java.util.List;

class Database implements Cloneable {
    
    private final ExternalAPI externalAPI = new ExternalAPI();
    
    private HashMap<String, List<String>> database = new HashMap<>();
    
    @Override
    public Database clone() {
        Database newDatabase = new Database();
        newDatabase.clone(this.database);
        return newDatabase;
    }
    
    private void clone(HashMap<String, List<String>> database) {
        this.database = new HashMap<>(database);
    }
    
    void initializeDictionaries() {
        HashMap<String, List<String>> dictionaries = externalAPI.getDictionaries();
        database.putAll(dictionaries);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result *= 31 + database.hashCode();
        result *= 31 + externalAPI.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Database))
            return false;
        
        Database otherDatabase = (Database)object;
    
        return otherDatabase.hashCode() == this.hashCode();
    }
    
}
