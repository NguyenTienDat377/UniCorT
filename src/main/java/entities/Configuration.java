package entities;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private String id;
    private Map<String, Subpart> subpart = new HashMap<>();

    //Configuration() {}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Subpart> getSubpart() {
        return new HashMap<>(subpart);
    }

    public void setSubpart(Map<String, Subpart> subpart) {
        this.subpart = new HashMap<>(subpart);
    }

}
