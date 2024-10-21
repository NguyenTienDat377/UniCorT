package constraints;

import entities.Time;
import solver.Factory;
import entities.Class;

import java.util.List;

import constraints.utils.Utils;

import java.util.ArrayList;

public class NotOverlap {
    public static boolean compare(Time ti, Time tj) {
        return ((ti.getEnd() <= tj.getStart()) || (tj.getEnd() <= ti.getStart()) || DifferentDays.compare(ti, tj) || DifferentWeeks.compare(ti, tj));
    }

    public static void remove(Class ci, Class cj) {
        List<Time> removeList = new ArrayList<>();
        for (Time ti : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time tj : cj.getTimes().keySet()) {
                if (NotOverlap.compare(ti, tj)) {
                    keep = true;
                    break;
                }
            }
            if (!keep) {
                removeList.add(ti);
            }
        }
        for (Time t : removeList) {
            ci.getTimes().remove(t);
        }
    }
    public static void resolve(Class ci, Class cj, boolean isRequired, int penalty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!NotOverlap.compare(t2, t1)) {
                    if (isRequired) {
                        Utils.addHardConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2));
                    } else {
                        Utils.addSoftConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), isRequired, penalty);
                    }
                }
            }
        }
    }
}
