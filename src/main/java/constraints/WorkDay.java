package constraints;

import entities.Class;
import entities.Time;

public class WorkDay {
    public static boolean compare (Time ti, Time tj, int V) {
        return (ti.getStart() + tj.getLength()) - tj.getStart() >= V; 
    }

    public static void remove(Class ci, Class cj) {

    }

    public static void resolve(Class ci, Class cj) {
        
    }
}
