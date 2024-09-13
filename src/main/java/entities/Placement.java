package entities;

public class Placement {
    private Room room;
    private Time time;

    Placement(Room room, Time time) {
        this.room = room;
        this.time = time;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
}
