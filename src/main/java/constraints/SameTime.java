package constraints;

import entities.Time;

public class SameTime {
    public static boolean compare(Time ti, Time tj) {
        return (((ti.getStart() <= tj.getStart()) && (tj.getEnd() <= ti.getEnd())) || ((tj.getStart() <= ti.getStart()) && (ti.getEnd() <= tj.getEnd())));
    }
}
