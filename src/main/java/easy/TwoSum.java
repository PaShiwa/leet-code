package src.main.java.easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i=0; i<n; i++){
            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                return new int[] {numMap.get(complement),i};
            }
            numMap.put(nums[i],i);
        }
       return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums= {3,4,2,7};
        int target =9;
        int[] resultIndex = new TwoSum().twoSum(nums,target);
        System.out.println(Arrays.toString(resultIndex));
    }
}
