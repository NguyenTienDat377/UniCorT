package constraints;

import entities.Time;
import solver.Factory;
import entities.Class;

import java.util.List;

import constraints.utils.Utils;

import java.util.ArrayList;

public class DifferentTime {
    public static boolean compare(Time ti, Time tj) {
        return (ti.getEnd() <= tj.getStart() || tj.getEnd() <= ti.getStart());
    }

    public static void remove(Class ci, Class cj) {
        List<Time> removeList = new ArrayList<>();
        for (Time t1 : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (DifferentTime.compare(t2, t1)) {
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
    public static void resolve(Class ci, Class cj, boolean required, int penalty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) return;

            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) return;

                if (!DifferentTime.compare(t2, t1)) {
                    Utils.addDistributionConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), false, penalty);
                }
                
            }
        }
    }
}