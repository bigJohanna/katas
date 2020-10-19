package calculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers){
        var delimeter = "[,\n]";

        if(numbers.endsWith("\n")){
            throw new NumberFormatException();
        }

        if(usesCustomDelimeter(numbers)) {
            delimeter = customDelimeter(numbers);
            numbers = numbers.substring(4);
        }
        return Arrays.stream(numbers.split(delimeter)).mapToInt(Integer::parseInt).sum();
    }

    private String customDelimeter(String numbers) {
        return String.valueOf(numbers.charAt(numbers.indexOf('n')+1));
    }

    private boolean usesCustomDelimeter(String numbers) {

        return numbers.startsWith("//");
    }
}
