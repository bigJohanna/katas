package cucumber;

import java.util.List;

public class IsItFriday {
    public static String isItFriday(String today) {
        if( today.equals("Friday"))
            return "TGIF";
        return "Nope";
    }

    public static long countFridays(List<String> days) {
        return days.stream().filter(s -> s.equals("Friday")).count();
    }
}
