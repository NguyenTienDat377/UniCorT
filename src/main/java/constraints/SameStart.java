package constraints;

import com.google.ortools.sat.Literal;

import entities.Time;

public class SameStart {
    public static boolean compare(Time ti, Time tj) {
        return ti.getStart() == tj.getStart();
    }

    public static void remove() {

    }

    public static void resolve(Literal l1, Literal l2) {
        
    }
}
