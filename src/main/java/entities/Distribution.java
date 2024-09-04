package entities;

import java.util.List;
import java.util.ArrayList;

public class Distribution {
    private String name;
    private List<Class> classInDis;
    private boolean required;
    private int penalty;
    Distribution(String name, boolean required, int penalty) {
        this.name = name;
        this.classInDis = new ArrayList<>();
        this.required = required;
        this.penalty = penalty;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Class> getClassInDis() {
        return new ArrayList<>(classInDis);
    }

    public void setClassInDis(List<Class> classInDis) {
        this.classInDis = new ArrayList<>(classInDis);
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
