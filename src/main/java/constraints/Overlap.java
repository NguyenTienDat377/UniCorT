package constraints;

import constraints.utils.Utils;
import entities.Time;
import entities.Class;
import solver.Factory;

import java.util.List;
import java.util.ArrayList;

public class Overlap {
    public static boolean compare(Time ti, Time tj) {
        int tiEndTime = ti.getStart() + ti.getLength();
        int tjEndTime = tj.getStart() + tj.getLength();
        return (tiEndTime >= tj.getStart() || tjEndTime <= ti.getStart() ||((!DifferentDays.compare(ti, tj))) || (!DifferentWeeks.compare(ti, tj)));
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
    public static void resolve(Class ci, Class cj, boolean isRequired, int pelnaty) {
        for (Time t1 : Factory.getProblem().getTimes().values()) {
            if (ci.getTimes().get(t1) == null) continue;
            for (Time t2 : Factory.getProblem().getTimes().values()) {
                if (cj.getTimes().get(t2) == null) continue;
                if (!NotOverlap.compare(t2, t1)) {
                    Utils.addDistributionConstraint(ci.getTimes().get(t1), cj.getTimes().get(t2), isRequired, pelnaty);
                }
            }
        }
    }
}
