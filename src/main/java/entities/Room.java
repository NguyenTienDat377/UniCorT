package entities;

import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private Integer id;
    private String name;
    private String type;
    private int capacity;
    private boolean open = false;
    private ArrayList<Time> unavailable;
    private HashMap<Integer, Integer> travel;


    Room(int id, int capacity, String name, String type) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.type = type;
        this.travel = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getCapacity() {
        return capacity;
    }
    public boolean isOpen() {
        return open;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public HashMap<Integer, Integer> getTravel() {
        return travel;
    }
    public void setTravel(HashMap<Integer, Integer> travel) {
        this.travel = travel;
    }
    public ArrayList<Time> getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(ArrayList<Time> unavailable) {
        this.unavailable = unavailable;
    }

}
