package LeetCode.src.main.java.array;

import java.util.*;
public class TopKFrequentElementsBucketSort {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency for each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        // Create a bucket where frequency = index and populate it!
        List<Integer>[] buckets = new List[nums.length];
        for(int key: frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(buckets[frequency] ==null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // Collect top k frequent elements
        List<Integer> result = new ArrayList<>();
        for(int i =buckets.length-1; i>=0 && result.size() < k; i-- ){
            if(buckets[i]!=null){
                for(int num: buckets[i]){
                    result.add(num);
                    if(result.size() == k)
                        break;
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,3,4,4,4};
        int k = 3;
        System.out.println(Arrays.toString(new TopKFrequentElementsBucketSort().topKFrequent(nums, k)));
    }
}
