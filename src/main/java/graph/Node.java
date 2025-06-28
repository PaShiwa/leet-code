package LeetCode.src.main.java.graph;

import java.util.ArrayList;
import java.util.List;

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
