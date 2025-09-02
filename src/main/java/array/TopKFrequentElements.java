package LeetCode.src.main.java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
public int[] topKFrequent (int[] nums, int k){
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // Count the frequency of each element
    for(int num: nums){
        frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
    }

    // Make a min heap so that the least frequency remains on top
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a,b) -> a.getValue()- b.getValue());

    // Push into the heap, keep only K elements.
    for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
        minHeap.add(entry);
        if(minHeap.size()>k){
            minHeap.poll();
        }
    }

    // Extract result
    int[] result= new int[k];
    int i =0;
    while (!minHeap.isEmpty()){
        result[i] = minHeap.poll().getKey();
        i++;
    }
    return result;
}
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, k)));

    }
}
