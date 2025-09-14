package LeetCode.src.main.java.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SubmissionPublisher;

public class MaximumDepthOfBinaryTree {

    static class Node{
        int value;
        Node left;
        Node right;
        Node (){
        }
        Node (int value){
            this.value=value;
        }
        Node (int value, Node left, Node right){
            this.value=value;
            this. left = left;
            this.right = right;
        }
    }

    public int maxDepth(Node root){
        if (root == null)
            return 0;
        System.out.println(root.value);
        int leftSubTree = maxDepth(root.left);
        System.out.println(leftSubTree);
        int rightSubTree = maxDepth(root.right);
        System.out.println(rightSubTree);

        return 1 + Math.max(leftSubTree, rightSubTree);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left =  new Node(2);
        root.right =  new Node(7);
        root.left.left =  new Node(1);
        root.left.right =  new Node(3);
        root.right.left =  new Node(6);
        root.right.right =  new Node(9);
        root.right.left.left =  new Node(5);


        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }
}
