package entities;

import java.util.Map;

import com.google.ortools.sat.LinearExpr;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Problem {
    private String name;
    private int nrDays;
    private int nrWeeks;
    private int slotPerDays;

    private Optimization optimization;

    private Map<String, Room> rooms = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Time> times = new HashMap<>();
    private Map<String, Student> student = new HashMap<>();
    private Map<String, Class> classes = new HashMap<>();
    private ArrayList<Distribution> distributions = new ArrayList<>();

    private ArrayList<LinearExpr> softDistributionExpr = new ArrayList<>();

    public Problem(){
        
    }

    public Problem(String name, int nrDays, int nrWeeks) {
        this.name = name;
        this.nrDays = nrDays;
        this.nrWeeks = nrWeeks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrDays() {
        return nrDays;
    }

    public void setNrDays(int nrDays) {
        this.nrDays = nrDays;
    }

    public int getNrWeeks() {
        return nrWeeks;
    }

    public void setNrWeeks(int nrWeeks) {
        this.nrWeeks = nrWeeks;
    }

    public int getSlotPerDays() {
        return slotPerDays;
    }

    public void setSlotPerDays(int slotPerDays) {
        this.slotPerDays = slotPerDays;
    }
    public Optimization getOptimization() {
        return optimization;
    }

    public void setOptimization(Optimization optimization) {
        this.optimization = optimization;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Room> rooms) {
        this.rooms = rooms;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, Course> courses) {
        this.courses = courses;
    }

    public Map<String, Time> getTimes() {
        return times;
    }

    public void setTimes(Map<String, Time> times) {
        this.times = times;
    }

    public Map<String, Student> getStudent() {
        return student;
    }

    public void setStudent(Map<String, Student> student) {
        this.student = student;
    }

    public Map<String, Class> getClasses() {
        return new HashMap<>(classes);
    }

    public void setClasses(Map<String, Class> classes) {
        this.classes = new HashMap<>(classes);
    }

    public List<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(ArrayList<Distribution> distributions) {
        this.distributions = distributions;
    }

    public ArrayList<LinearExpr> getSoftDistributionExpr() {
        return softDistributionExpr;
    }

    public void setSoftDistributionExprs(ArrayList<LinearExpr> softDistributionExprs) {
        this.softDistributionExpr = softDistributionExprs;
    }
}
