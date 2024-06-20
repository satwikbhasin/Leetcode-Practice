/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private HashMap<Node, Node> cloned;

    private Node cloneNode(Node node) {
        if (node == null)
            return null;

        if (!cloned.containsKey(node)) {
            cloned.put(node, new Node(node.val));
        }

        return cloned.get(node);
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        cloned = new HashMap<>();

        Node oldHead = head;

        while (oldHead != null) {
            Node clonedNode = cloneNode(oldHead);
            clonedNode.random = cloneNode(oldHead.random);
            clonedNode.next = cloneNode(oldHead.next);
            oldHead = oldHead.next;
        }

        return cloned.get(head);
    }
}