package constraints;

import constraints.utils.Utils;
import entities.Class;
import entities.Room;
import solver.Factory;

import java.util.List;
import java.util.ArrayList;

public class DifferentRoom {
    public static boolean compare(Room ri, Room rj) {
        return ri.getId() != rj.getId();
    }

    public static void remove(Class ci, Class cj) {
        List<Room> removeList = new ArrayList<>();

        for (Room r1 : ci.getRooms().keySet()) {
            boolean keep = false;
            for (Room r2 : cj.getRooms().keySet()) {
                if (DifferentRoom.compare(r1, r2)) {
                    keep = true;
                    break;
                }

            }

            if (!keep) {
                removeList.add(r1);
            }
        }
        
        for (Room r : removeList) {
            ci.getRooms().remove(r);
        }

    }

    public static void resolve(Class ci, Class cj, boolean isRequired, int pelnaty) {
        if (ci.getRoomList().isEmpty() || cj.getRoomList().isEmpty()) {
            return;
        }
        for (Room r1 : Factory.getProblem().getRooms().values()) {
            if (ci.getRooms().get(r1) == null) continue;

            for (Room r2 : Factory.getProblem().getRooms().values()) {
                if (cj.getRooms().get(r2) == null) continue;

                if (!DifferentRoom.compare(r1, r2)) {
                    Utils.addDistributionConstraint(ci.getRooms().get(r1), cj.getRooms().get(r2), isRequired, pelnaty);
                }
            }
        }
    }
}
