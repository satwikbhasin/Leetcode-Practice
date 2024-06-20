class MaxStack {

    private class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }

    }

    private TreeMap<Integer, Stack<Node>> map;
    private Node head;
    private Node tail;

    public MaxStack() {
        this.map = new TreeMap<>();
        this.head = new Node(0);
        this.tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    // O(log n)
    public void push(int x) {
        Node newNode = new Node(x);
        map.computeIfAbsent(x, k -> new Stack<>()).push(newNode);
        insertNode(newNode);
    }

    // O(log n)
    public int pop() {
        Node removedNode = popNode();
        int removedNodeVal = removedNode.val;
        map.get(removedNodeVal).pop();
        if (map.get(removedNodeVal).isEmpty()) {
            map.remove(removedNodeVal);
        }
        return removedNodeVal;
    }

    // O(1)
    public int top() {
        return tail.prev.val;
    }

    // O(log n)
    public int peekMax() {
        return map.lastKey();
    }

    // O(log n)
    public int popMax() {
        int maxVal = map.lastKey();
        Node maxNode = map.get(maxVal).pop();
        if (map.get(maxVal).isEmpty()) {
            map.remove(maxVal);
        }
        removeNode(maxNode);
        return maxVal;
    }

    // O(1)
    private void insertNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    // O(1)
    private Node popNode() {
        Node removedNode = tail.prev;
        removedNode.prev.next = tail;
        tail.prev = removedNode.prev;
        return removedNode;
    }

    // O(1)
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */