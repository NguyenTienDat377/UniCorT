package constraints;

import entities.Room;
import entities.Class;

import java.util.List;
import java.util.ArrayList;
public class SameRoom {
    public static boolean compare(Room ri, Room rj) {
        return ri.getId() == rj.getId();
    }

    public static void remove(Class ci, Class cj) {
        if (ci.getRoomList().size() == 0 || cj.getRoomList().size() == 0) {
            return;
        }

        List<Room> removeRoom = new ArrayList<>();

        for (Room r1 : ci.getRooms().keySet() ) {
            boolean keep = false;

            for (Room r2 : ci.getRooms().keySet()) {
                if (SameRoom.compare(r1, r2)) {
                    keep = false;
                    break;
                }
            }
            if (!keep) {
                removeRoom.add(r1);
            }
        }
        for (Room r1 : removeRoom) {
            ci.getRooms().remove(r1);
        }
    }

    public static void resolve(Room r1, Room rj, boolean isRequired, int pelnaty) {
        
    }
    
}
