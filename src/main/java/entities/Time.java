package entities;
public class Time {
    private int start;
    private int length;
    private String day;
    private String week;

    public Time(int start, int length, String day, String week) {
        this.start = start;
        this.length = length;
        this.day = day;
        this.week = week;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public int getEnd() {
        return this.start + this.length;
    }
}
