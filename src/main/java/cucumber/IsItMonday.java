package cucumber;

public class IsItMonday {
    public static String isItMonday(String today) {
        if( today.equals("Monday"))
            return "Stay in bed";
        return "";
    }
}
