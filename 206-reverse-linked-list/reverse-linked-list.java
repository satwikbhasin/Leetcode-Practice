/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reversed;

    private ListNode recursion(ListNode node) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            reversed = node;
            return node;
        }

        ListNode nextNode = recursion(node.next);
        nextNode.next = node;
        node.next = null;
        return node;
    }

    public ListNode reverseList(ListNode head) {
        recursion(head);
        return reversed;
    }
}