package LeetCode.src.main.java.linkedlist;

import java.util.HashMap;

public class LRUCache {

    class Node{
        int key, value;
        Node prev, next;

        Node( int key, int value){
            this.key = key;
            this.value= value;
        }
    }
    private final int capacity;
    Node head, tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this .capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int x){
        if (map.containsKey(x)){
            Node node = map.get(x);
            // Need to remove the node and keep it to the front as soon as you touch it.
            remove(node);
            insertToFront(node);
            return node.value;
        }
        System.out.println(x + " doesn't exist!");
        return -1;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insertToFront(node);

        if(map.size()>capacity){
            Node lru = tail.prev;
            // If addition of the new element exceeds the capacity, remove it.
            remove(lru);
            // Removing node alone is not sufficient, Key should be removed too. The size is the size of the map. Keeping ke increases the size
            map.remove(lru.key);
        }
    }

    private void remove (Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node){
        // Connect the node to the head and the previous first element
        node.prev = head;
        node.next = head.next;

        // Connect the previous first element to the new node (Now 1st element)
        head.next.prev = node;
        // Connect head to the new node
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }
}
