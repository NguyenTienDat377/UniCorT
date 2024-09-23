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
        for (Time ti : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(ti) == null) continue;
            for (Time tj : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(tj) == null) continue;
                if (!WorkDay.compare(ti, tj, V)) {
                    Utils.addDistributionConstraint(ci.getTimes().get(ti), cj.getTimes().get(tj), isRequired, pelnaty);
                }
            }
        }
    }
}
