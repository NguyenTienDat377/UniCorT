package constraints;

import entities.Time;

public class DifferentTime {
    public static boolean compare(Time ti, Time tj) {
        return (ti.getEnd() <= tj.getStart() || tj.getEnd() <= ti.getStart());
    }
    
}