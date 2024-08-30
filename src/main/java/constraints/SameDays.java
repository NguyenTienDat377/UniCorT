package constraints;

import entities.Class;
import constraints.utils.Utils;

public class SameDays {
    public static boolean compare(Class ci, Class cj) {
        return Utils.andDay(ci.getPossibleDays(), cj.getPossibleDays());
    }
}
