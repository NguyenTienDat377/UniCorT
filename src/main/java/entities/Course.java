package entities;

import java.util.Map;
import java.util.HashMap;

public class Course {
    private String id;
    private String name;
    private String teacherId;
    private Map<String, Configuration> configurations = new HashMap<>();
    private int limit;
    private int numberOfStudent;

    public Course(){}

    Course(String name, String teacherId, int limit, int numberOfStudent) {
        this.name = name;
        this.teacherId = teacherId;
        this.limit = limit;
        this.numberOfStudent = numberOfStudent;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Map<String, Configuration> getConfigurations() {
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

    public void setConfigurations(Map<String, Configuration> configurations) {
        this.configurations = new HashMap<>(configurations);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public void addStudent() {
        numberOfStudent++;
    }
}
