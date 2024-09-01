package entities;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private int id;
    private Map<String, Subpart> subpart = new HashMap<>();

    Configuration(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Subpart> getSubpart() {
        return new HashMap<>(subpart);
    }

    public void setSubpart(Map<String, Subpart> subpart) {
        this.subpart = new HashMap<>(subpart);
    }

}
