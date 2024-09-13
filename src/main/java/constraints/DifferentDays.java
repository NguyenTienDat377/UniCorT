package constraints;

import constraints.utils.Utils;
import entities.Class;
import entities.Time;

public class DifferentDays {
    public static boolean compare(Time ti, Time tj) {
        String andDay = Utils.andDay(ti, tj);
        for (int i = 0; i < andDay.length(); i++) {
            if (andDay.charAt(i) == '1') return false; 
        }
        return true;
    }

    public static void remove(Class c1, Class c2) {
        
    }

    public static void resolve(Class ci, Class cj) {
        
    }
}
