package LeetCode.src.main.java.array;

import java.util.HashSet;
import java.util.Set;
public class ContainsDuplicates {
    public boolean hasDuplicate(int[] intArray){
        Set<Integer> seen = new HashSet<>();
        for (int i: intArray){
            if(seen.contains(i)){
                System.out.println("The first duplicate is: " + i);
                return true;
            }
            seen.add(i);
        }
        return  false;
    }
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3,4, 4, 4};
        boolean result = new ContainsDuplicates().hasDuplicate(intArray);
        System.out.println(result);
    }
}

