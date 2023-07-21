import java.io.*;
import java.util.*;

public class VisibleNode {
    /*
There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes at each level. Return the number of visible nodes.
Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at a level could be a right node.
Signature
int visibleNodes(Node root) {
Input
The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000
Output
An int representing the number of visible nodes.
Example

            8  <------ root
           / \
         3    10
        / \     \
       1   6     14
          / \    /
         4   7  13

output = 4
 */

    class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int max = 0;
    public int visibleNodes(Node root){
        return findNodes(root, 1);
    }

    public int findNodes(Node node, int level){
        int count = 0;
        if(node == null)
            return 0;
        if(max < level){
            max = level;
            count = 1;
        }
        count += findNodes(node.left, level+1);
        count += findNodes(node.right, level+1);
        return count;
    }

    public void run(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(5);
        int result = visibleNodes(root);
        System.out.println(result);
    }
    public static void main(String [] args){
        new VisibleNode().run();

    }

}
