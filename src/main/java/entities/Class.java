package entities;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

import com.google.ortools.sat.Literal;

public class Class implements Comparable<Class> {
    private int id;
    private int limit;

    private Class parentClass;

    private ArrayList<Penalty<Room>> roomList;
    private ArrayList<Penalty<Time>> timesList;

    private Map<Room, Literal> rooms = new HashMap<>();
    private Map<Time, Literal> times = new HashMap<>();

    private Set<Time> unavailable = new HashSet<>();

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

    public ArrayList<Penalty<Room>> getRoomList() {
        return new ArrayList<>(roomList);
    }

    public ArrayList<Penalty<Time>> getTimeList() {
        return new ArrayList<>(timesList);
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
    
    

    public void setRoom(Map<Room, Literal> rooms) {
        this.rooms = new HashMap<>(rooms);
    }

    public Map<Room, Literal> getRooms() {
        return new HashMap<>(rooms);
    }

    public void setRooms(Map<Room, Literal> rooms) {
        this.rooms = new HashMap<>(rooms);
    }

    public Map<Time, Literal> getTimes() {
        return new HashMap<>(times);
    }

    public void setTimes(Map<Time, Literal> times) {
        this.times = new HashMap<>(times);
    }

    public HashSet<Time> getUnavailable() {
        return new HashSet<>(unavailable);
    }

    public void setUnavailable(HashSet<Time> unavailable) {
        this.unavailable = new HashSet<>(unavailable);
    }

    public void setRoomList(ArrayList<Penalty<Room>> roomList) {
        this.roomList = new ArrayList<>(roomList);
    }

    public void setTimesList(ArrayList<Penalty<Time>> timesList) {
        this.timesList = new ArrayList<>(timesList);
    }

    @Override
    public int compareTo(Class other) {
        if (other == null) {
            throw new NullPointerException();
        }

    }
    

}

