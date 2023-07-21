import java.util.*;

public class BinaryTreeAverage {
    /*
    Input :
    4
   / \
  2   9
 / \   \
3   5   7

Output : [4 5.5 5]
The average value of nodes on level 0 is 4,
on level 1 is 5.5, and on level 2 is 5.
Hence, print [4 5.5 5].
     */
    class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.left =  null;
            this.right =  null;
            this.data = data;
        }
    }

    public List<Double> findAverage(Node root){
        List<Double> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int sum=0, count=0;
        while(!q.isEmpty()){
            sum = 0;
            count = 0;
            Queue<Node> temp = new LinkedList<>();
            while(!q.isEmpty()){
                Node node = q.remove();
                sum += node.data;
                count++;

                if(node.left != null)
                    temp.add(node.left);
                if(node.right != null)
                    temp.add(node.right);
            }
            result.add((sum*1.0)/count);
            q = temp;
        }
        return result;
    }

    public void run(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(9);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        List<Double> result = findAverage(root);
        for(Double d : result){
            System.out.println(d);
        }
    }

    public static  void main(String[] args){
        new BinaryTreeAverage().run();
    }
}
