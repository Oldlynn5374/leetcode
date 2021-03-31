package 其他.腾讯;

import java.util.*;

public class LRUCache_146 {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int listSize = 0;
    private int capacity;
    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null){
            return -1;
        }
        put(key, map.get(key).val);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            Node n = map.get(key);

            remove(n);

            map.put(key, node);
            enqueue(node);
            return;
        }else if (listSize >= capacity){
            dequeue();
        }
        enqueue(node);

    }

    public void enqueue(Node node){
        map.put(node.key, node);
        Node prev = tail.prev;
        node.next = tail;
        node.prev = prev;
        prev.next = node;
        tail.prev = node;
        listSize++;
    }

    public void dequeue(){
        Node out = head.next;
        head.next = out.next;
        out.next.prev = head;
        map.remove(Integer.valueOf(out.key));
        listSize--;
    }

    public void remove(Node n){
        Node pre = n.prev;
        Node next = n.next;
        pre.next = next;
        next.prev = pre;
        listSize--;
    }

    public static void main(String[] args) {
        LRUCache_146 cache = new LRUCache_146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}

class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }

    public Node() {
    }
}
