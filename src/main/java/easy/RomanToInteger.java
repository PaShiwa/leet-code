package src.main.java.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put('I',1);
        stringIntegerHashMap.put('V',5);
        stringIntegerHashMap.put('X',10);
        stringIntegerHashMap.put('L',50);
        stringIntegerHashMap.put('C',100);
        stringIntegerHashMap.put('D',500);
        stringIntegerHashMap.put('M',1000);

        int sum=0;
        for (int i=0;i<s.length()-1;i++){
            if(stringIntegerHashMap.get(s.charAt(i)) < stringIntegerHashMap.get(s.charAt(i+1))){
                sum-= stringIntegerHashMap.get(s.charAt(i));
            }
            else {
                sum+= stringIntegerHashMap.get(s.charAt(i));
            }
        }
        return sum+stringIntegerHashMap.get(s.charAt(s.length()-1));
    }

    public static void main(String[] args) {
        int integerValue = new RomanToInteger().romanToInt("MCMXCIV");
        System.out.println(integerValue);
    }
}