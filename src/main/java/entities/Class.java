package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.google.ortools.sat.Literal;

public class Class {
    private int id;

    private int limit;

    private Class parentClass;

    private List<Room> possibleRooms = new ArrayList<>();

    private Map<String, Literal> hour = new HashMap<>();

    private Map<String, Literal> day = new HashMap<>();

    

    Class(int id, int limit) {
        this.id = id;
        this.limit = limit;
        parentClass = null;
    }

    Class(Class classs) {
        this.id = classs.getId();
        this.limit = classs.getLimit();
        this.parentClass = classs.getParentClass();
    }

    public int getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }

    public Class getParentClass() {
        return new Class(parentClass);
    }

    public List<Room> getPossibleRooms() {
        return new ArrayList<>(possibleRooms);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setParentClass(Class parentClass) {
        this.parentClass = new Class(parentClass);
    }

    public void setPossibleRooms(List<Room> possibleRooms) {
        this.possibleRooms = possibleRooms;
    }
    
    public Map<String, Literal> getHour() {
        return new HashMap<>(hour);
    }

    public void setHour(Map<String, Literal> hour) {
        this.hour = new HashMap<>(hour);
    }

    public Map<String, Literal> getDay() {
        return new HashMap<>(day);
    }

    public void setDay(Map<String, Literal> day) {
        this.day = new HashMap<>(day);
    }

    public void addRoom(Room room) {
        possibleRooms.add(room);
    }


}
