package constraints;

import java.util.ArrayList;
import java.util.List;

import constraints.utils.Utils;
import entities.Time;
import entities.Class;
import solver.Factory;

public class SameWeeks {
    public static boolean compare(Time ti, Time tj) {
        String orWeek = Utils.orWeek(ti, tj);
        return orWeek.equals(ti.getWeek()) || orWeek.equals(tj.getWeek());
    }
    public static void remove(Class ci, Class cj) {
        List<Time> removeList = new ArrayList<>();
        for (Time t1 : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (SameWeeks.compare(t1, t2)) {
                    keep = true;
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
    public static void resolve(Class ci, Class cj, boolean isRequired, int pelnaty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!DifferentWeeks.compare(t2, t1)) {
                    Utils.addDistributionConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), isRequired, pelnaty);
                }
            }
        }
    }
}
