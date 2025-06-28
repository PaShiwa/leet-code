package LeetCode.src.main.java.graph;

import java.util.*;


public class CloneGraphBFS {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Clone the root node
        Node cloneRoot = new Node(node.value);
        cloneMap.put(node, cloneRoot);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    // Clone neighbor
                    Node clonedNeighbor = new Node(neighbor.value);
                    cloneMap.put(neighbor, clonedNeighbor);
                    queue.offer(neighbor);
                }

                // Link the clone of current node to the clone of neighbor
                cloneMap.get(current).neighbors.add(cloneMap.get(neighbor));
            }
        }

        return cloneRoot;
    }

    // Optional: helper to print the graph for verification
    public void printGraph(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.value)) return;

        visited.add(node.value);
        System.out.print("Node " + node.value + " -> ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.value + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        CloneGraphBFS gc = new CloneGraphBFS();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);

        Node cloned = gc.cloneGraph(n1);

        System.out.println("Original Graph:");
        gc.printGraph(n1, new HashSet<>());

        System.out.println("Cloned Graph:");
        gc.printGraph(cloned, new HashSet<>());
    }
}
