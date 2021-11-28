package sample.fbprep;

import java.util.HashMap;

public class LRUCache {

    // TC - O(1)
    // SC - O(N)

    HashMap<Integer, Node> store = new HashMap<>();

    int cap, size = 0;

    // head - LRU
    // tail - MRU
    Node head, tail;

    class Node{
        int data, key;
        Node prev, next;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", key=" + key +
                    '}';
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node current){
        // add to tail beacuse MRU
        current.next = tail;
        current.prev = tail.prev;
        tail.prev.next = current;
        tail.prev = current;
    }

    public void remove(Node current){
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public void update(Node current){
        remove(current);
        add(current);
    }

    public int get(int key) {
        Node current = store.get(key);

        if(current == null) return -1;

        update(current);

        //System.out.println(store);

        return current.data;
    }

    public void put(int key, int value) {
        Node current = store.get(key);

        if(current == null){
            // new entry
            current = new Node(key, value);
            store.put(key, current);
            size++;
            add(current);

        }else{
            // old entry
            current.data = value;
            update(current);
        }

        if(size > cap){
            size--;
            store.remove(head.next.key);
            remove(head.next);
        }

        //System.out.println(store);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

}
