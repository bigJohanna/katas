package calculator;

public class StringCalculator {

    public int add(String numbers){
        int sum = 0;

        String[] nums = numbers.split(",|\\n");
        try{
            for(String s : nums) {
                sum += Integer.parseInt(s);
            }

           }catch(IllegalArgumentException e){
               return 0;
           }
             return sum;
    }
}
