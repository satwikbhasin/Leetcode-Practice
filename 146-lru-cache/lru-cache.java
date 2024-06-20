class LRUCache {

    private class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node node = this.map.get(key);
        removeNode(node);
        insertToLast(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.val = value;
            removeNode(node);
            insertToLast(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                removeLeastUsed();
            }
            this.map.put(key, newNode);
            insertToLast(newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeLeastUsed() {
        Node lru = head.next;
        map.remove(lru.key);
        removeNode(lru);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */