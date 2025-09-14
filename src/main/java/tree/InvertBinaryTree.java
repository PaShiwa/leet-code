package LeetCode.src.main.java.tree;

import java.util.*;

public class InvertBinaryTree {

    public Node invertTree(Node root) {
        if (root == null) return null;

        System.out.println(root.value);
        // Swap children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

// Safe debug prints
        if (root.left != null) {
            System.out.println("Left child: " + root.left.value);
        } else {
            System.out.println("Left child: null");
        }

        if (root.right != null) {
            System.out.println("Right child: " + root.right.value);
        } else {
            System.out.println("Right child: null");
        }


        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        System.out.println(root.value);
        return root;
    }

    // Level-order (BFS) traversal to match LeetCode output
    public List<Integer> levelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        InvertBinaryTree sol = new InvertBinaryTree();

        // Build sample tree: [4,2,7,1,3,6,9]
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        System.out.println("Before inversion: " + sol.levelOrder(root));

        root = sol.invertTree(root);

        System.out.println("After inversion: " + sol.levelOrder(root));
    }
}
