package LeetCode.src.main.java.array;

import java.util.Arrays;
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int productLeft=1;
        int[] result = new int[nums.length];

        for (int i=0; i< nums.length; i++){
            result[i] = productLeft;
            productLeft = productLeft * nums[i];
        }

        int productRight = 1;
        for (int i=nums.length-1; i>=0; i--){
                result[i] *= productRight;
                productRight = productRight * nums[i];
            }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1,0,3,4};
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(nums)));

    }
}
