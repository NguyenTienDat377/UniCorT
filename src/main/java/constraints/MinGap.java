package constraints;

import entities.Time;
import solver.Factory;
import entities.Class;

import java.util.List;

import constraints.utils.Utils;

import java.util.ArrayList;


public class MinGap {
    public static boolean compare(Time t1, Time t2, int V) {
        return DifferentDays.compare(t1, t2) || DifferentWeeks.compare(t1, t2) || t1.getEnd() + V >= t2.getStart() || t2.getEnd() + V >= t1.getStart();
    }
    public static void remove(Class ci, Class cj, int V) {
        List<Time> removeList = new ArrayList<>();
        for (Time ti : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (MinGap.compare(ti, t2, V)) {
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

    public static void resolve(Class ci, Class cj,int V, boolean isRequired, int penalty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!MinGap.compare(t2, t1, V)) {
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
