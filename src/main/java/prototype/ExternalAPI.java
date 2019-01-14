package prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ExternalAPI {
    
    
    public HashMap<String, List<String>> getDictionaries() {
        List<String> languages = new ArrayList<>(3);
        List<String> versionControl = new ArrayList<>(3);
        List<String> projectNames = new ArrayList<>(5);
    
        languages.add("Java");
        languages.add("Kotlin");
        languages.add("Powershell");
        
        versionControl.add("Git");
        versionControl.add("SVN");
        versionControl.add("Mercurial");
    
        projectNames.add("Bank mobile application");
        projectNames.add("VOIP System");
        projectNames.add("Game");
    
    
        HashMap<String, List<String>> dictionaries = new HashMap<>();
        dictionaries.put("languages", languages);
        dictionaries.put("version_control", versionControl);
        dictionaries.put("project_names", projectNames);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
            // acting as long working service
        }
    
        return dictionaries;
    }
    
    @Override
    public int hashCode() {
        // all instances are equal
        return 1;
    }
}
