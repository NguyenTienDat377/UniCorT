package constraints.utils;

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



}
