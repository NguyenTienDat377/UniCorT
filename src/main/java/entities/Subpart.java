package entities;

import java.util.ArrayList;
import java.util.List;

public class Subpart {
    private int id;
    private List<Class> classes;

    public Subpart(int id, int configurationId) {
        this.id = id;
        this.classes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Class> getClasses() {
        return classes;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
