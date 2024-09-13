package constraints;

import constraints.utils.Utils;
import entities.Time;

public class SameDays {
    public static boolean compare(Time ti, Time tj) {
        String orDay = Utils.orDay(ti, tj);
        return (orDay.equals(ti.getDay()) || orDay.equals(tj.getDay()));
    }

    public static void remove() {

    }

    

}
