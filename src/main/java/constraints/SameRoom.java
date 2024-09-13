package constraints;

import entities.Room;
public class SameRoom {
    public static boolean compare(Room ri, Room rj) {
        return ri.getId() == rj.getId();
    }
    
}
