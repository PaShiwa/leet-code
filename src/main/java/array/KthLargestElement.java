package LeetCode.src.main.java.array;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
public class KthLargestElement {
    public static int findKthLargest(int[] numbers, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: numbers){
            minHeap.offer(num);
            if(minHeap.size() > k ){
                minHeap.poll();
            }
        }
        try {
            return minHeap.peek();
        } catch (NullPointerException e){
            throw new NullPointerException("Heap is Empty!");
        }
    }

    public static void main(String[] args){
        int[] numbers = {2,3,4,5,6};
        int k = 3;

        System.out.println("The third largest element: "+ findKthLargest(numbers,k));
    }
}
