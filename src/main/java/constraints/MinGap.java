package constraints;

import entities.Time;
import entities.Class;


public class MinGap {
    public static boolean compare(Time t1, Time t2, int V) {
        return DifferentDays.compare(t1, t2) || DifferentWeeks.compare(t1, t2) || t1.getEnd() + V >= t2.getStart() || t2.getEnd() + V >= t1.getStart();
    }
    public static void remove(Class ci, Class cj, int V) {
        
        for (Time ti : ci.getTimes().keySet()) {
            boolean keep = false;
            for (Time t2 : cj.getTimes().keySet()) {
                if (MinGap.compare(ti, t2, V)) {
                    keep = true;
                    break;
                }
            }
            if (!keep) {

            }
        }
    }

    public static void resolve(Class ci, Class cj, int V, boolean isRequired, int pelnaty) {

    }
}
