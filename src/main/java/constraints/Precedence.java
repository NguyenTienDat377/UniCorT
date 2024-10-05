package constraints;

import entities.Time;
import solver.Factory;
import entities.Class;

import java.util.List;

import constraints.utils.Utils;

import java.util.ArrayList;

public class Precedence {
    public static boolean compare(Time ti, Time tj) {
        return (ti.getStart() > tj.getStart());
    }
    public static void remove(Class ci, Class cj) {
        List<Time> removeList = new ArrayList<>();
        for (Time ti : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time tj : cj.getTimes().keySet()) {
                if (Precedence.compare(ti, tj)) {
                    keep = false;
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
    public static void resolve(Class ci, Class cj, boolean isRequired, int pelnaty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!Precedence.compare(t2, t1)) {
                    Utils.addDistributionConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), isRequired, pelnaty);
                }
            }
        }
    }
}
