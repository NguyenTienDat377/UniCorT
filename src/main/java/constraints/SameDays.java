package constraints;

import constraints.utils.Utils;
import entities.Class;
import entities.Time;
import solver.Factory;

import java.util.List;
import java.util.ArrayList;

public class SameDays {
    public static boolean compare(Time ti, Time tj) {
        String orDay = Utils.orDay(ti, tj);
        return (orDay.equals(ti.getDay()) || orDay.equals(tj.getDay()));
    }

    public static void remove(Class ci, Class cj) {
        List<Time> removeList = new ArrayList<>();
        for (Time t1 : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (SameDays.compare(t2, t1)) {
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
    public static void resolve(Class ci, Class cj, boolean isRequired, int penalty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : cj.getTimes().keySet()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!SameDays.compare(t1, t2)) {
                    Utils.addDistributionConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), isRequired, penalty);
                }
            }
        }
    }
    

}
