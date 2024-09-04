package entities;

import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private int id;
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

    public int getId() {
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
