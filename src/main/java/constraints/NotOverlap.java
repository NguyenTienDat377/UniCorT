package constraints;

import entities.Time;

public class NotOverlap {
    public static boolean compare(Time ti, Time tj) {
        return ((ti.getEnd() <= tj.getStart()) || (tj.getEnd() <= ti.getStart()) || DifferentDays.compare(ti, tj) || DifferentWeeks.compare(ti, tj));
    }
    
}
