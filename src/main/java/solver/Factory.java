package solver;

import com.google.ortools.sat.CpModel;
import entities.Problem;

public class Factory {
    public static CpModel cpModel = null;
    public static Problem problem = null;

    private Factory(){}

    public void init() {
        if (cpModel == null) {
            cpModel = new CpModel();
        }
        if (problem == null) {
            problem = new Problem();
        }
    }
    public static CpModel getCpModel() {
        return cpModel;
    }

    public static void setCpModel(CpModel cpModel) {
        Factory.cpModel = cpModel;
    }

    public static Problem getProblem() {
        return problem;
    }

    public static void setProblem(Problem problem) {
        Factory.problem = problem;
    }
    
}
