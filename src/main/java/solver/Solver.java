package solver;

import com.google.ortools.sat.CpSolver;


public class Solver {
    private CpSolver solver;
    private Solver() {
    }

    public CpSolver getSolver() {
        if (solver == null) {
            solver = new CpSolver();
        }
        return solver;
    }
}
