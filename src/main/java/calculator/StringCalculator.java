package calculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    private final int MAX_VALUE = 1000;

    public int add(String numbers){
        var delimeter = "[,\n]";

        endsWithLineBreakCheck(numbers);

        if(usesCustomDelimeter(numbers)) {
            delimeter = customDelimeter(numbers);
            var customLength = 4;
            if(delimeter.length()>1){
                numbers = numbers.replace(delimeter, ",");
                delimeter = ",";
                customLength += 2;
            }
            numbers = numbers.substring(customLength);
        }

        return getSum(numbers, delimeter);
    }

    private int getSum(String numbers, String delimeter) {
        containsNegativeNumbersCheck(numbers, delimeter);
        return Arrays.stream(numbers.split(delimeter))
                .mapToInt(Integer::parseInt)
                .filter(n->n<=MAX_VALUE)
                .sum();
    }

    private void containsNegativeNumbersCheck(String numbers, String delimeter) {
       var list = Arrays.stream(numbers.split(delimeter))
               .mapToInt(Integer::parseInt)
               .boxed()
               .filter(n->n<0)
               .collect(Collectors.toList());
        if(list.size() > 0){
            var message = "negatives not allowed";
            for (int n: list
                 ) {
              message += "," + n;
            }
            throw new IllegalArgumentException(message);
        }
    }

    private void endsWithLineBreakCheck(String numbers) {
        if(numbers.endsWith("\n")){
            throw new NumberFormatException();
        }
    }

    private String customDelimeter(String numbers) {
        if(numbers.startsWith("//[")) {
            return numbers.substring(numbers.indexOf('[')+1, numbers.indexOf(']'));
        }
        else{
        return String.valueOf(numbers.charAt(numbers.indexOf('\n')-1));
        }
    }

    private boolean usesCustomDelimeter(String numbers) {
        return numbers.startsWith("//");
    }
}
