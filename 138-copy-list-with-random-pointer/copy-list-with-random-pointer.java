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
    HashMap<Node, Node> visited;

    private Node getClonedNode(Node node) {
        if (node == null)
            return null;

        if (!visited.containsKey(node)) {
            visited.put(node, new Node(node.val));
        }

        return visited.get(node);
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        visited = new HashMap<>();

        Node old = head;
        Node newNode = getClonedNode(old);

        while (old != null) {
            newNode.random = getClonedNode(old.random);
            newNode.next = getClonedNode(old.next);

            old = old.next;
            newNode = newNode.next;
        }

        return visited.get(head);
    }
}