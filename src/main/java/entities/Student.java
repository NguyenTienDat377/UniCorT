package entities;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.google.ortools.sat.Literal;

public class Student {
    private int id;
    private List<Course> courses;
    private Map<Class, Literal> classes = new HashMap<>();

    Student(int id) {
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Map<Class, Literal> getClasses() {
        return classes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setClasses(Map<Class, Literal> classes) {
        this.classes = classes;
    }
}
