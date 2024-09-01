package entities;

import java.util.Map;
import java.util.HashMap;

public class Course {
    private String name;
    private String teacherId;
    private Map<Integer, Configuration> configurations = new HashMap<>();
    private int limit;
    private int numberOfStudent;

    Course(String name, String teacherId, int limit, int numberOfStudent) {
        this.name = name;
        this.teacherId = teacherId;
        this.limit = limit;
        this.numberOfStudent = numberOfStudent;
    }
    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Map<Integer, Configuration> getConfigurations() {
        return new HashMap<>(configurations);
    }

    public int getLimit() {
        return limit;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setConfigurations(Map<Integer, Configuration> configurations) {
        this.configurations = new HashMap<>(configurations);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public void addStudent() {
        numberOfStudent++;
    }
}
