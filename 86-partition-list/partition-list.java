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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        Queue<ListNode> queue = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;

        while (curr != null) {
            if (curr.val >= x) {
                queue.offer(curr);
            } else {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }

        while (!queue.isEmpty()) {
            prev.next = queue.poll();
            prev = prev.next;
        }

        prev.next = null;

        return dummy.next;
    }
}