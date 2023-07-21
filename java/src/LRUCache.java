import java.util.*;
/*Let’s say we have a LRU cache of capacity 2.
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10); // it will store a key (1) with value 10 in the cache.
        cache.set(2, 20); // it will store a key (2) with value 20 in the cache.
        cache.get(1); // returns 10
        cache.set(3, 30); // evicts key 2 and store a key (3) with value 30 in the cache.
        cache.get(2); // returns -1 (not found)
        cache.set(4, 40); // evicts key 1 and store a key (4) with value 40 in the cache.
        cache.get(1); // returns -1 (not found)
        cache.get(3); // returns 30
        cache.get(4); // returns 40*/
public class LRUCache {
    Node head;
    Node tail;
    int capacity;
    int count;
    Map<Integer,Node> map;
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.pre = null;
        this.tail.next = null;
        this.head.next = tail;
        this.tail.pre = head;
        this.count = 0;
        map = new HashMap<>();
    }

    public void set(int key, int value){
        Node node;
        node = new Node(key, value);
        map.put(key, node);
        if (count == capacity) {
            map.remove(tail.pre.key);
            deleteNode(tail.pre);
            addToHead(node);
        }
        else{
            addToHead(node);
            count++;
        }
    }

    public int get(int key){
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return map.get(key).value;
        }
        else
            return -1;
    }

    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    public void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    class Node{
        Node pre;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String []args){
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10); // it will store a key (1) with value 10 in the cache.
        cache.set(2, 20); // it will store a key (2) with value 20 in the cache.
        System.out.println(cache.get(1)); // returns 10
        cache.set(3, 30); // evicts key 2 and store a key (3) with value 30 in the cache.
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.set(4, 40); // evicts key 1 and store a key (4) with value 40 in the cache.
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 30
        System.out.println(cache.get(4)); // returns 40*/
    }
}
