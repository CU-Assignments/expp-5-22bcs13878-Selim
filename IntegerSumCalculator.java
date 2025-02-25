import java.util.*;

public class IntegerSumCalculator {
    public static void main(String[] args) {
        List<String> numberStrings = Arrays.asList("10", "20", "30", "40", "50");
        
        List<Integer> numbers = parseStringListToIntegers(numberStrings);
        
        int sum = calculateSum(numbers);
        
        System.out.println("Sum of integers: " + sum);
    }
    
    public static List<Integer> parseStringListToIntegers(List<String> numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : numberStrings) {
            numbers.add(Integer.parseInt(str)); // Autoboxing
        }
        return numbers;
    }
    
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing
        }
        return sum;
    }
}