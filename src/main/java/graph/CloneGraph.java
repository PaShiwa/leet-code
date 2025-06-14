package LeetCode.src.main.java.graph;

import java.util.*;
class Node {
    public int value;
    public List<Node> neighbors;

    public Node() {
        value = 0;
        neighbors = new ArrayList();
    }

    public Node(int val) {
        this.value = val;
        neighbors = new ArrayList();
    }

    public Node(int val, List<Node> neighbors) {
        value = 0;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {
      private static Map<Node,Node> visited = new HashMap<>();

      public static Node cloneGraph(Node node){
          if(node == null){
              return null;
          }

          if(visited.containsKey(node)){
              return visited.get(node);
          }

          Node clone = new Node(node.value);
          visited.put(node,clone);

          for(Node neighbor: node.neighbors){
              clone.neighbors.add(cloneGraph(neighbor));
          }
          return clone;
      }

      public static void printGraph(Node node){
          Set<Integer> printed = new HashSet<>();
          Queue<Node> queue = new LinkedList<>();
          queue.add(node);

          while (!queue.isEmpty()) {
              Node current = queue.poll();
              if (printed.contains(current.value)) continue;

              printed.add(current.value);
              System.out.print("Node " + current.value + " neighbors: ");
              for (Node neighbor : current.neighbors) {
                  System.out.print(neighbor.value + " ");
                  queue.add(neighbor);
              }
              System.out.println();
          }
      }
      public static void main(String[] args){
          Node node1 = new Node(1);
          Node node2 = new Node(2);
          Node node3 = new Node(3);
          Node node4 = new Node(4);

          node1.neighbors.addAll(Arrays.asList(node2, node4));
          node2.neighbors.addAll(Arrays.asList(node1, node3));
          node3.neighbors.addAll(Arrays.asList(node2, node4));
          node4.neighbors.addAll(Arrays.asList(node1, node3));

          System.out.println("Original Graph..");
          printGraph(node1);

          visited.clear();
          Node cloned = cloneGraph(node1);

          System.out.println("\nCloned Graph!");
          printGraph(cloned);
      }
    }

