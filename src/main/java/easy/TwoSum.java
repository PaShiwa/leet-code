package src.main.java.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] twoSumArray = twoSum(numbers,target);
        if (twoSumArray!=null) {
            System.out.println("Two sum: " + Arrays.toString(twoSumArray));
        }else {
            System.out.println("No solution exists!");
        }
    }

    static int[] twoSum(int[] numbers,int target){
        Map<Integer,Integer> numMap = new HashMap<>();
        int n = numbers.length;
        for(int i =0;i<n; i++){
            int complement = target-numbers[i];
            if(numMap.containsKey(complement)){
                return new int[] {numMap.get(complement),i};
            }
            numMap.put(numbers[i],i);
        }
        return null;
    }
}