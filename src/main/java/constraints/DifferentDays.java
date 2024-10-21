package constraints;

import java.util.List;
import java.util.ArrayList;

import constraints.utils.Utils;
import entities.Class;
import entities.Time;
import solver.Factory;

public class DifferentDays {
    public static boolean compare(Time ti, Time tj) {
        String andDay = Utils.andDay(ti, tj);
        for (int i = 0; i < andDay.length(); i++) {
            if (andDay.charAt(i) == '1')
                return false;
        }
        return true;
    }

    public static void remove(Class c1, Class c2) {
        List<Time> removeList = new ArrayList<>();
        for (Time t1 : c1.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (DifferentDays.compare(t2, t1)) {
                    keep = true;
                    break;
                }
            }
            if (!keep) {
                removeList.add(t1);
            }
        }
        for (Time t : removeList) {
            c1.getTimes().remove(t);
        }
    }

    public static void addConstraint(Class ci, Class cj, boolean isRequired, int penalty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null)
                continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null)
                    continue;
                if (!DifferentDays.compare(t1, t2)) {
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
