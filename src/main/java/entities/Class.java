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

    private List<Room> possibleRooms;

    private Map<String, Literal> hour;

    private Map<String, Literal> day;

    Class(int id, int limit) {
        this.id = id;
        this.limit = limit;
        parentClass = null;
        this.possibleRooms = new ArrayList<>();
    }

    Class(Class classs) {
        this.id = classs.getId();
        this.limit = classs.getLimit();
        this.parentClass = classs.getParentClass();
        this.possibleRooms = new ArrayList<>(this.getPossibleRooms());
    }

    public int getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }

    public Class getParentClass() {
        return parentClass;
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
        this.parentClass = parentClass;
    }

    public void setPossibleRooms(List<Room> possibleRooms) {
        this.possibleRooms = possibleRooms;
    }


}
