import java.util.HashMap;
import java.util.Map;

public class LRUCachePrac {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value= value;
        }
    }

    int capacity;
    int count;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCachePrac(int capacity){
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        count = 0;
    }

    public void deleteNode(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    public void addToHead(Node n){
        n.next = head.next;
        head.next.pre = n;
        n.pre = head;
        head.next = n;
    }

    public void set(int key, int value){
        Node n = new Node(key, value);
        if(count >= capacity){
            deleteNode(tail);
            map.remove(tail.value);
            count--;
        }
        addToHead(n);
        if(!map.containsKey(key)){
            map.put(key, n);
            count++;
        }
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return 0;
        }
        else{
            Node n = map.get(key);
            deleteNode(n);
            addToHead(n);
            return n.value;
        }
    }

    public static void main(String[] args){
        LRUCachePrac lru = new LRUCachePrac(5);

    }
}
