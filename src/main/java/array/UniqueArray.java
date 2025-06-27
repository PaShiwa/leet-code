package LeetCode.src.main.java.array;

/*
A Java program that Returns a list of unique elements from the original array. Tracks and returns a map of duplicate items along with their positions (indexes) in the original array.
 */
import java.util.*;
public class UniqueArray {

    public static<T> void removeDuplicates(T[] array){
        Set<T> seen = new HashSet<>();
        List<T> uniqueArray = new ArrayList<>();
        Map<T,List<Integer>> duplicatesWithIndices = new HashMap<>();

        for(int i =0; i<array.length;i++){
            T element = array[i];

            if(!seen.contains(element)){
                seen.add(element);
                uniqueArray.add(element);
            }else{
                duplicatesWithIndices
                        .computeIfAbsent(element, k-> new ArrayList<>())
                        .add(i);
            }
        }

        System.out.println("Unique Elements: " + uniqueArray );

        System.out.println("Duplicate Elements and Their Indices:");
        for (Map.Entry<T, List<Integer>> entry : duplicatesWithIndices.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    public static void main(String[] args){
        String[] originalArray = {"apple","banana","apple","banana","grape","apple"};
        removeDuplicates(originalArray);
    }
}
