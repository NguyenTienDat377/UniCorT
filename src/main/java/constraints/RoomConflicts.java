package constraints;

import constraints.utils.Utils;
import entities.Room;
import entities.Time;
import solver.Factory;
import entities.Class;

import java.util.List;
import java.util.ArrayList;

public class RoomConflicts {
    public static boolean compare(Room ri, Room rj, Time ti, Time tj) {
        return Overlap.compare(ti, tj) || (ti.getStart() < tj.getEnd() + rj.getTravel().get(ri.getId())) || (tj.getStart() < ti.getEnd() + ri.getTravel().get(rj.getId())); 
    }
    public static void remove(Class ci, Class cj) {
        List<Room> roomRemoveList = new ArrayList<>();
        List<Time> timeRemoveList = new ArrayList<>();
        for (Room ri : ci.getRooms().keySet()) {
            boolean keepRoom = false;
            for (Room rj : cj.getRooms().keySet()) {
                for (Time ti : ci.getTimes().keySet()) {
                    boolean keepTime = false;
                    for (Time tj : cj.getTimes().keySet()) {
                        if (RoomConflicts.compare(ri, rj, ti, tj)) {
                            keepTime = true;
                            keepRoom = true;
                            break;
                        }
                    }
                    if (!keepTime) {
                        timeRemoveList.add(ti);
                    }
                }
            }
            if (!keepRoom) {
                roomRemoveList.add(ri);
            } 
        }
        for (Room r : roomRemoveList) {
            ci.getRooms().remove(r);
        }
        for (Time t : timeRemoveList) {
            ci.getTimes().remove(t);
        }
    }
    public static void resolve(Class ci, Class cj, boolean isRequired, int penalty) {
        for (Time ti : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(ti) == null) continue;
            for (Time tj : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(tj) == null) continue;
                for (Room ri : Factory.getProblem().getRooms().values()) {
                    if (ci.getRooms().get(ri) == null) continue;
                    for (Room rj : Factory.getProblem().getRooms().values()) {
                        if (cj.getRooms().get(rj) == null) continue;
                        if (RoomConflicts.compare(ri, rj, ti, tj)) {
                            if (isRequired) {
                                Utils.addFourLiteralHardConstraint(ci.getTimes().get(ti), cj.getTimes().get(tj), ci.getRooms().get(ri), cj.getRooms().get(rj));
                            } else {
                                Utils.addFourLiteralSoftConstraint(ci.getTimes().get(ti), cj.getTimes().get(tj), ci.getRooms().get(ri), cj.getRooms().get(rj), isRequired, penalty);
                            }
                        }
                    }
                }
            }
        }
    }


}
