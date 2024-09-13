package constraints;

import constraints.utils.Utils;
import entities.Time;

public class SameWeeks {
    public static boolean compare(Time ti, Time tj) {
        String orWeek = Utils.orWeek(ti, tj);
        return orWeek.equals(ti.getWeek()) || orWeek.equals(tj.getWeek());
    }
}
