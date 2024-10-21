package entities;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.ortools.sat.Literal;

public class Class implements Comparable<Class> {
    private String id;
    private int limit;

    private Class parentClass;

    private ArrayList<Penalty<Room>> roomList;
    private ArrayList<Penalty<Time>> timesList;

    private Map<Room, Literal> rooms = new HashMap<>();
    private Map<Time, Literal> times = new HashMap<>();
    private Map<Integer, Literal> hours = new HashMap<>();
    private Map<String, Literal> days = new HashMap<>();
    private Map<String, Literal> weeks = new HashMap<>();

    private Map<Time, Literal> unavailable = new HashMap<>();

    public Class() {}

    Class(Class aClass) {
        this.id = aClass.getId();
        this.limit = aClass.getLimit();
        this.parentClass = aClass.getParentClass();
    }

    public String getId() {
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

    public void setId(String id) {
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

    public void setRoomList(ArrayList<Penalty<Room>> roomList) {
        this.roomList = new ArrayList<>(roomList);
    }

    public void setTimesList(ArrayList<Penalty<Time>> timesList) {
        this.timesList = new ArrayList<>(timesList);
    }

    public Map<Integer, Literal> getHour() {
        return new HashMap<>(hours);
    }

    public void setHour(Map<Integer, Literal> hours) {
        this.hours = new HashMap<>(hours);
    }

    public Map<String, Literal> getDays() {
        return new HashMap<>(days);
    }

    public void setDays(Map<String, Literal> days) {
        this.days = new HashMap<>(days);
    }

    public Map<String, Literal> getWeeks() {
        return new HashMap<>(weeks);
    }

    public void setWeeks(Map<String, Literal> weeks) {
        this.weeks = new HashMap<>(weeks);
    }

    public Map<Time, Literal> getUnavailableTime() {
        return new HashMap<>(unavailable);
    }

    public void setUnavailable(Map<Time, Literal> unavailable) {
        this.unavailable = new HashMap<>(unavailable);
    }

    @Override
    public int compareTo(Class other) {
        return this.id.compareTo(other.getId());
    }

}
