package constraints;

import entities.Room;
import entities.Class;
import entities.Time;
import solver.Factory;

import java.util.List;

import constraints.utils.Utils;

import java.util.ArrayList;

public class RoomUnavailability {
    public static boolean compare(Time t1, Time t2) {
        return Overlap.compare(t1, t2);
    }
    public static void remove(Class c) {
        List<Room> removeList = new ArrayList<>();
        for (Room r : c.getRooms().keySet()) {
            for (Time t1 : r.getUnavailable()) {
                boolean keep = false;
                for (Time t2 : c.getUnavailable()) {
                    if (RoomUnavailability.compare(t1, t2)) {
                        keep = true;
                        break;
                    }
                }
                if (!keep) {
                    removeList.add(r);
                }
            }
        }
        for (Room r : removeList) {
            c.getRooms().remove(r);
        }
    }

    public static void resolve(Class c, boolean isRequired, int penalty) {
        for (Room r : Factory.getProblem().getRooms().values()) {
            if (c.getRooms().get(r) == null) continue;
            for (Time t1 : c.getTimes().keySet()) {
                for (Time t2 : r.getUnavailable()) {
                    if (!RoomUnavailability.compare(t1, t2)) {
                        Utils.addDistributionConstraint(c.getRooms().get(r), c.getTimes().get(t1).not(), isRequired, penalty);
                    }
                }
            }
        }
    }
}
