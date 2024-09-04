package entities;

public class Unavalability {  
    private int start;
    private int end;
    private String days;
    private String weeks;
    
    Unavalability(int start, int end, String days, String weeks) {
        this.start = start;
        this.end = end;
        this.days = days;
        this.weeks = weeks;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }
}
