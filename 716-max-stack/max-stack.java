class MaxStack {

    private class Node {
        int val;
        Node prev, next;
        int timeStamp;

        Node(int val, int timeStamp) {
            this.val = val;
            this.timeStamp = timeStamp;
        }

    }

    private PriorityQueue<Node> pq;
    private Node head;
    private Node tail;
    private int timeStamp;

    public MaxStack() {
        this.pq = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return Integer.compare(b.val, a.val); // Compare values in descending order
            } else {
                return Integer.compare(b.timeStamp, a.timeStamp); // Compare timestamps in descending order for
                                                                  // duplicates
            }
        });

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.timeStamp = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x, timeStamp++);
        pq.offer(newNode);
        insertNode(newNode);
    }

    public int pop() {
        Node removedNode = popNode();
        pq.remove(removedNode);
        return removedNode.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return pq.peek().val;
    }

    public int popMax() {
        Node maxNode = pq.poll();
        removeNode(maxNode);
        return maxNode.val;
    }

    private void insertNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private Node popNode() {
        Node removedNode = tail.prev;
        removedNode.prev.next = tail;
        tail.prev = removedNode.prev;
        return removedNode;
    }

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