package constraints;

import entities.Class;
import entities.Time;
import solver.Factory;

import java.util.List;

import constraints.utils.Utils;

import java.util.ArrayList;

public class WorkDay {
    public static boolean compare (Time ti, Time tj, int V) {
        return (ti.getStart() + tj.getLength()) - tj.getStart() >= V; 
    }

    public static void remove(Class ci, Class cj, int V) {
        List<Time> removeList = new ArrayList<>();
        for (Time t1 : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (WorkDay.compare(t1, t2, V)) {
                    keep = true;
                    break;
                }
            }
            if (!keep) {
                removeList.add(t1);
            }
        }
        for (Time t : removeList) {
            ci.getTimes().remove(t);
        }
    }

    public static void resolve(Class ci, Class cj, int V, boolean isRequired, int pelnaty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!WorkDay.compare(t1, t2, V)) {
                    if (isRequired) {
                        Utils.addHardConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2));
                    } else {
                        Utils.addSoftConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), isRequired, pelnaty);
                    }
                }
            }
        }
    }
}
