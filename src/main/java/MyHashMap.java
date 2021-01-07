/*
        All keys and values will be in the range of [0, 1000000].
        The number of operations will be in the range of [1, 10000].
        Please do not use the built-in HashMap library.
*/


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 *
 * Runtime: 12 ms
 * Memory Usage: 42 MB
 *
 *
 */
class MyHashMap {

    class Node {
        private int key, val;
        private Node next;

        public void setVal(int val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    Node[] nodes;
    int numberOfBuckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        numberOfBuckets = 1000; // number of buckets
        nodes = new Node[numberOfBuckets];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = hash(key);
        Node cur = nodes[bucket];
        if (cur == null) {
            nodes[bucket] = new Node(key, value);
        } else updateOrAddKV(key, value, cur);
    }

    private void updateOrAddKV(int key, int value, Node cur) {
        if (cur.key == key) {
            cur.val = value;
        } else {
            cur = findClosestPrevNode(key, cur);
            if (cur.next != null) {
                cur.next.val = value;
            } else cur.next = new Node(key, value);
        }
    }

    private Node findClosestPrevNode(int key, Node prev) {
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = hash(key);
        return findValue(key, bucket);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = hash(key);
        Node cur = nodes[bucket];
        if (cur != null) {
            if (cur.key != key) {
                removeInNext(key, cur);
            } else nodes[bucket] = cur.next;
        }
    }

    private void removeInNext(int key, Node cur) {
        cur = findClosestPrevNode(key, cur);
        if (cur.next != null) cur.next = cur.next.next;
    }

    private int findValue(int key, int bucket) {
        Node cur = nodes[bucket];
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        if (cur != null) {
            return cur.val;
        } else return -1;
    }

    private int hash(int key) {
        return key % numberOfBuckets;
    }
}
