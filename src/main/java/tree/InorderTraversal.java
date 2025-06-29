package LeetCode.src.main.java.tree;

import java.util.*;
import java.util.ArrayList;

public class InorderTraversal {
    List<Integer> inorderList = new ArrayList<>();
    public void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        inorderList.add(node.value);
        System.out.println("Added:" + node.value);
        inOrder(node.right);
    }

    public List<Integer> getInorder(Node node){
        inOrder(node);
        return inorderList;
    }

    public static void main(String[] args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node (7);
        root.left.left = new Node(1);
        root.left.right = new Node (4);
        root.right.left = new Node(6);
        root.right.right = new Node (8);

        InorderTraversal it = new InorderTraversal();
        List<Integer> inorder = it.getInorder(root);

        System.out.println("Inorder Traversal: "+ inorder);
    }
}
