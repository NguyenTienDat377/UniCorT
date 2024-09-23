package constraints;

import constraints.utils.Utils;
import entities.Time;
import solver.Factory;
import entities.Class;

import java.util.List;
import java.util.ArrayList;

public class DifferentWeeks {
    public static boolean compare(Time ti, Time tj) {
        String orWeek = Utils.orWeek(ti, tj);
        for (int i = 0; i < orWeek.length(); i++) {
            if (orWeek.charAt(i) == '1') return false;
        }
        return true;
    }

    public static void remove(Class ci, Class cj) {
        List<Time> removeList = new ArrayList<>();
        for (Time t1 : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (DifferentWeeks.compare(t1, t2)) {
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
