package hack3;

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

class SolutionHack3 {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        int h = height(root) + 1;
        int i;
        for (i=1; i<=h; i++)
        {
            printGivenLevel(root, i);
        }
    }

    static void printGivenLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

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
        levelOrder(root);
    }
}