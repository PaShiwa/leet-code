package src.main.java.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String romanValue = "XVIII";
        int integerValue = findIntegerValue(romanValue);
        System.out.println("Integer value of " + romanValue + " is " + integerValue);
    }

    private static int findIntegerValue(String romanValue) {
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        int sum = 0;
        int n = romanValue.length();

        for (int i = 0; i < n; i++) {
            // If the current numeral is smaller than the next, subtract it
            if (i < n - 1 && romanToInt.get(romanValue.charAt(i)) < romanToInt.get(romanValue.charAt(i + 1))) {
                sum -= romanToInt.get(romanValue.charAt(i));
            } else {
                // Otherwise, add it
                sum += romanToInt.get(romanValue.charAt(i));
            }
        }
        return sum;
    }
}
