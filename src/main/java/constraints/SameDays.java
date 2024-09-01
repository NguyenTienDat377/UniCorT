package constraints;

import entities.Time;
import constraints.utils.Utils;

public class SameDays {
    public static boolean compare(Time ci, Time cj) {
        String days = Utils.andDay(ci, cj);
        for (int i = 0; i < days.length(); i++) {
            if (days.charAt(i) == '1') return true;
        }
        return false;
    }

}
