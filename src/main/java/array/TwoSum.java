package LeetCode.src.main.java.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] intArray, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< intArray.length; i++){
            int compliment = target-intArray[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }
            map.put(intArray[i],i);
        }
        return null;
    }
    public static void main(String[] args) {
        int[] intArray = {2,6,3,4,5,1};
        int target = 5;
        System.out.println(Arrays.toString(new TwoSum().twoSum(intArray, target)));
    }
}
