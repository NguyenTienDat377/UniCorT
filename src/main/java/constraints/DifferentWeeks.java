package constraints;

import constraints.utils.Utils;
import entities.Time;

public class DifferentWeeks {
    public static boolean compare(Time ti, Time tj) {
        String orWeek = Utils.orWeek(ti, tj);
        for (int i = 0; i < orWeek.length(); i++) {
            if (orWeek.charAt(i) == '1') return false;
        }
        return true;
    }

    
}
