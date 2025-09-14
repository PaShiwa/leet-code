package LeetCode.src.main.java.tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        System.out.println(root.val);
        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

// Safe debug prints
        if (root.left != null) {
            System.out.println("Left child: " + root.left.val);
        } else {
            System.out.println("Left child: null");
        }

        if (root.right != null) {
            System.out.println("Right child: " + root.right.val);
        } else {
            System.out.println("Right child: null");
        }


        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        System.out.println(root.val);
        return root;
    }

    // Level-order (BFS) traversal to match LeetCode output
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        InvertBinaryTree sol = new InvertBinaryTree();

        // Build sample tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Before inversion: " + sol.levelOrder(root));

        root = sol.invertTree(root);

        System.out.println("After inversion: " + sol.levelOrder(root));
    }
}
