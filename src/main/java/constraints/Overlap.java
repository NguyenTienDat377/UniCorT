package constraints;

import entities.Time;

public class Overlap {
    public static boolean compare(Time ti, Time tj) {
        int tiEndTime = ti.getStart() + ti.getLength();
        int tjEndTime = tj.getStart() + tj.getLength();
        return (tiEndTime >= tj.getStart() || tjEndTime <= ti.getStart() ||((!DifferentDays.compare(ti, tj))) || (DifferentWeeks.compare(ti, tj)));
    }
    
       
}
