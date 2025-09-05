package LeetCode.src.main.java.twopointer;

import java.util.Arrays;

public class TwoSum {
    int[] twoSum(int[] numbers, int target){
        int left =0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum==target){
                return new int[]{left+1, right +1};
            }
           else if(sum<target){
                left ++;
            }
            else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] numbers ={1,2,3,4,5};
        int target = 7;
        int[] result = new TwoSum().twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}
