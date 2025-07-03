package LeetCode.src.main.java.array;

import java.util.PriorityQueue;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    // Utility method to print a linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Utility method to create linked list from array
    static ListNode fromArray(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap (PriorityQueue) to keep smallest node at the top
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head of each list to heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge all nodes
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // Get smallest node
            current.next = node;            // Append it to result
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next); // Push next node from same list
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create input: 3 sorted linked lists
        ListNode l1 = ListNode.fromArray(new int[]{1, 4, 5});
        ListNode l2 = ListNode.fromArray(new int[]{1, 3, 4});
        ListNode l3 = ListNode.fromArray(new int[]{2, 6});

        // Combine into array
        ListNode[] lists = new ListNode[]{l1, l2, l3};

        // Merge
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode result = solution.mergeKLists(lists);

        // Print result
        System.out.print("Merged List: ");
        ListNode.printList(result);
    }
}
