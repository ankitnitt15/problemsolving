import java.util.*;

public class BinaryTreeLevelSum {
    /* Given the root node of a binary tree, return a dictionary where the key is the level and the value is the sum of all nodes on that level.


Input:

       10
     /    \
    5      1
  /   \    /\
 2    3   4  0

Left = level - 1
Right = level + 1
Output: {0: 17, -1: 5, -2: 2, 1: 1, 2:0} */
    class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    static Map<Integer,Integer> sum = new HashMap<>();
    public void findLevelSum(Node root){
        findSum(root, 0);
        //return sum;
    }

    public void findSum(Node node, int level){
        if(node == null)
            return;
        if(sum.containsKey(level)){
            sum.put(level, sum.get(level)+ node.data);
        }
        else
            sum.put(level, node.data);
        findSum(node.left, level-1);
        findSum(node.right, level+1);
    }

    public void run(){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(0);
        findLevelSum(root);
    }

    public static void main(String[] args){
        new BinaryTreeLevelSum().run();
        for(Map.Entry<Integer,Integer> entry : sum.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
