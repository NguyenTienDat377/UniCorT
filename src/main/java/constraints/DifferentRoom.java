package constraints;

import entities.Class;
import entities.Room;

public class DifferentRoom {
    public static boolean compare(Room ri, Room rj) {
        return ri.getId() != rj.getId();
    }

    public static void remove(Class ci, Class cj) {
        
    }

    public static void resolve(Class ci, Class cj, boolean isRequired, int pelnaty) {
        if (ci.getRoomList().isEmpty() || cj.getRoomList().isEmpty()) {
            return;
        }
        for (Room r : )
    }
}
