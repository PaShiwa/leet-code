package LeetCode.src.main.java.tree;

public class KthSmallestInBST {

    // Counter to track how many nodes we've visited
    private int count = 0;

    // Variable to store the Kth Smallest value when found
    private int result = -1;

    public int kthSmallest(Node root, int k) {
        // Perform in-order traversal (Left → Root → Right)
        inorder(root, k);
        return result;
    }

    /**
     * In-order traversal with tracking of the current rank
     */
    private void inorder(Node node, int k) {
        if (node == null) return;

        // Traverse left subtree first
        inorder(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.value;
            return; // Found the answer, no need to continue
        }

        // Traverse right subtree
        inorder(node.right, k);
    }

    // Sample usage
    public static void main(String[] args) {
        // Build BST
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        KthSmallestInBST finder = new KthSmallestInBST();
        int k = 3;

        System.out.println("Kth smallest element: " + finder.kthSmallest(root, k)); // Output: 3
    }
}

