package src.main.java.easy;

public class RemoveElement {
    public int removeElement(int[] nums, int value){
        int i =0;
        int index = 0;
        while (i<nums.length){
            if (nums[i]!=value){
                nums[index]= nums[i];
                index++;
            }
            i++;
        }
        return index ;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,3,4};
        int value = 3;
        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElement(nums, value);
        System.out.println(result);
    }
}
