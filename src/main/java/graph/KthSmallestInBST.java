package LeetCode.src.main.java.graph;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class KthSmallestInBST {

    // Counter to track how many nodes we've visited
    private int count = 0;

    // Variable to store the Kth smallest value when found
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        // Perform in-order traversal (Left → Root → Right)
        inorder(root, k);
        return result;
    }

    /**
     * In-order traversal with tracking of the current rank
     */
    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        // Traverse left subtree first
        inorder(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.val;
            return; // Found the answer, no need to continue
        }

        // Traverse right subtree
        inorder(node.right, k);
    }

    // Sample usage
    public static void main(String[] args) {
        // Build BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestInBST finder = new KthSmallestInBST();
        int k = 3;

        System.out.println("Kth smallest element: " + finder.kthSmallest(root, k)); // Output: 3
    }
}

