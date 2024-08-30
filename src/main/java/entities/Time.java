package entities;

import java.util.List;
import java.util.ArrayList;

public class Time {
    private int start;
    private int end;
    private String day;
    private String week;
    private List<Integer> classesAssigned;
    public Time(int start, int end, String day, String week) {
        this.start = start;
        this.end = end;
        this.day = day;
        this.week = week;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
