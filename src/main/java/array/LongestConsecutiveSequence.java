package LeetCode.src.main.java.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutiveSequenceLength(int[] numbers){
        if (numbers.length == 0) {
            return 0;
        }

        HashSet<Integer> numberSet = new HashSet<>();
        for(int num: numbers){
            numberSet.add(num);
        }

        int longest =0;

        for(int num:numbers){
            if(!numberSet.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;

                while(numberSet.contains(currentNum+1)){
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest ;
    }
    public static void main(String[] args) {
        int[] numbers = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutiveSequenceLength(numbers));

    }
}
