package constraints.utils;

public class Utils {
    public static String andDay(String days1, String days2) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < days1.length(); i++) {
            char c1 = days1.charAt(i);
            char c2 = days2.charAt(i);
            expression.append((c1 & c2));
        }
        return expression.toString();
    }

}
