package entities;

import java.util.Map;
import java.util.HashMap;

public class Subpart {
    private String id;
    private Map<String, Class> classes = new HashMap<>();

    public Subpart() {
    }

    public String getId() {
        return id;
    }

    public Map<String, Class> getClasses() {
        return classes;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setClasses(Map<String, Class> classes) {
        this.classes = new HashMap<>(classes);
    }
}
