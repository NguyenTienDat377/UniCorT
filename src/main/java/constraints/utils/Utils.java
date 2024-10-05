package constraints.utils;

import com.google.ortools.sat.Literal;
import com.google.ortools.sat.LinearExpr;
import com.google.ortools.sat.Constraint;

import solver.ConstraintHandler;
import solver.Factory;

import entities.Time;

public class Utils {
    // day and day
    public static String andDay(Time t1, Time t2) {
        StringBuilder day = new StringBuilder();
        String Day1 = t1.getDay();
        String Day2 = t2.getWeek();
        for (int i = 0; i < Day1.length(); i++) {
            int day1 = Day1.charAt(i) - '0';
            int day2 = Day2.charAt(i) - '0'; 
            day.append(day1 & day2);
        }
        return day.toString();
    }
    // day or day
    public static String orDay(Time t1, Time t2) {
        StringBuilder day = new StringBuilder();
        String Day1 = t1.getDay();
        String Day2 = t2.getDay();
        for (int i = 0; i < Day1.length(); i++) {
            int day1 = Day1.charAt(i) - '0';
            int day2 = Day2.charAt(i) - '0';
            day.append(day1 | day2);
        }
        return day.toString();
    }
    // week and week
    public static String andWeek(Time t1, Time t2) {
        StringBuilder week = new StringBuilder();
        String Week1 = t1.getWeek();
        String Week2 = t2.getWeek();
        for (int i = 0; i < Week1.length(); i++) {
            int week1 = Week1.charAt(i) - '0';
            int week2 = Week2.charAt(i) - '0';
            week.append(week1 & week2);
        }
        return week.toString();
    }
    // week or week
    public static String orWeek(Time t1, Time t2) {
        StringBuilder week = new StringBuilder();
        String Week1 = t1.getWeek();
        String Week2 = t2.getWeek();
        for (int i = 0; i < Week1.length(); i++) {
            int week1 = Week1.charAt(i);
            int week2 = Week2.charAt(i);
            week.append(week1 | week2);
        }
        return week.toString();
    }

    public static void addHardConstraint(Literal t1, Literal t2) {
        Factory.getCpModel().addBoolOr(new Literal[]{t1.not(), t2.not()});
    }

    public static void addSoftConstraint(Literal l1, Literal l2, boolean isRequired, int pelnaty) {
        if (isRequired) {
            Literal[] l = new Literal[] {
                l1.not(), l2.not()
            };
            Factory.getCpModel().addBoolOr(new Literal[]{l1.not(), l2.not()});
            //LinearExpr expr = LinearExpr.weightedSum({}, null)
            LinearExpr expr = LinearExpr.weightedSum(l, new long[]{(long) Factory.getProblem().getOptimization().getDistribution() * pelnaty});
            Factory.getProblem().getSoftDistributionExpr().add(expr);
        }
    }

    public static void addFourLiteralHardConstraint(Literal l1, Literal l2, Literal l3, Literal l4) {
        Factory.getCpModel().addBoolOr(new Literal[]{l1.not(), l2.not(), l3.not(), l4.not()});
    }

    public static void addFourLiteralSoftConstraint(Literal l1, Literal l2, Literal l3, Literal l4, boolean isRequired, int pelnaty) {
        if (isRequired) {
            Literal[] l = new Literal[] {
                l1.not(), l2.not(), l3.not(), l4.not()
            };
            Factory.getCpModel().addBoolOr(l);
            LinearExpr expr = LinearExpr.weightedSum(l, new long[] {(long) Factory.getProblem().getOptimization().getDistribution() * pelnaty});
            Factory.getProblem().getSoftDistributionExpr().add(expr);
        }
    }

    public static void addDistributionConstraint(Literal t1, Literal t2, boolean isRequired, int penalty) {
        Constraint pos = Factory.getCpModel().addBoolAnd(new Literal[]{t1, t2});
        Constraint neg = Factory.getCpModel().addBoolOr(new Literal[]{t1.not(), t2.not()});
        Literal l = ConstraintHandler.addConstraint(pos, neg);
        LinearExpr expr = LinearExpr.weightedSum(
            new Literal[]{l},
            new long[]{(long) Factory.getProblem().getOptimization().getDistribution() * penalty}
        );
        Factory.getProblem().getSoftDistributionExpr().add(expr);
    }

    public static void addFourDistributionConstraint(Literal c1, Literal c2, Literal t1, Literal t2, boolean isRequired, int pelnaty) {
        if (isRequired) {
            Factory.getCpModel().addBoolOr(new Literal[]{c1.not(), c2.not(), t1.not(), t2.not()});
        } else {
            Constraint pos = Factory.getCpModel().addBoolAnd(new Literal[]{c1, c2, t1, t2});
            Constraint neg = Factory.getCpModel().addBoolOr(new Literal[]{c1, c2, t1, t2});
            Literal l = ConstraintHandler.addConstraint(pos, neg);
            LinearExpr expr = LinearExpr.weightedSum(
                new Literal[]{l},
                new long[]{(long) Factory.getProblem().getOptimization().getDistribution() * pelnaty}
            );
            Factory.getProblem().getSoftDistributionExpr().add(expr);
        }
    }

}
