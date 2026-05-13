package Challange500;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        
        head = new Node(0 ,0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);

        System.out.println(cache.get(1));
        cache.put(4, 40);
        System.out.println(cache.get(2));

    }
}
