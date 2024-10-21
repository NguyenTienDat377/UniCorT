package constraints;

import constraints.utils.Utils;
import entities.Class;
import entities.Time;
import solver.Factory;
import entities.Room;

public class SameAttendees {
    public static boolean compare(Room ri, Room rj, Time ti, Time tj) {
        return Overlap.compare(ti, tj) && SameRoom.compare(ri, rj);
    }
    public static void resolve(Class ci, Class cj, boolean isRequired, int penalty) {
        for (Room ri : Factory.getProblem().getRooms().values()) {
            if (ci.getRooms().get(ri) == null) continue;
            for (Room rj : Factory.getProblem().getRooms().values()) {
                if (cj.getRooms().get(rj) == null) continue;
                for (Time ti : Factory.getProblem().getTimes().values()) {
                    if (ci.getTimes().get(ti) == null) continue;
                    for (Time tj : Factory.getProblem().getTimes().values()) {
                        if (cj.getTimes().get(tj) == null) continue;
                        if (SameAttendees.compare(rj, ri, ti, tj)) {
                            if (isRequired) {
                                Utils.addFourLiteralHardConstraint(ci.getTimes().get(ti), cj.getTimes().get(tj) , ci.getRooms().get(ri), cj.getTimes().get(tj));
                            } else {
                                Utils.addFourLiteralSoftConstraint(ci.getTimes().get(ti), cj.getTimes().get(tj) , ci.getRooms().get(ri), cj.getTimes().get(tj), isRequired, penalty);
                            }
                        }
                    }
                }
            }
        }
    }
}
