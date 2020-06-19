package hack2;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class SolutionHack2 {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        if (root == null) {
            //The first root height is considered -1
            return -1;
        } else {
            //Get the max from left and from right
            int lDepth = height(root.left);
            int rDepth = height(root.right);

            //Add 1 because de first root
            if (lDepth > rDepth)
                return (lDepth+1);
            else
                return (rDepth+1);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}