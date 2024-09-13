package solver;

import com.google.ortools.sat.Constraint;
import com.google.ortools.sat.Literal;

import utils.Random;

public class ConstraintHandler {
    public static Literal addCostraint(Constraint cons) {
        Literal c = Factory.getCpModel().newBoolVar(Random.getRandomHexString());
        cons.onlyEnforceIf(c);
        return c;
    }

    public static Literal addConstraint(Constraint pos, Constraint neg) {
        Literal c = Factory.getCpModel().newBoolVar(Random.getRandomHexString());
        pos.onlyEnforceIf(c);
        neg.onlyEnforceIf(c.not());
        return c;
    }
}
