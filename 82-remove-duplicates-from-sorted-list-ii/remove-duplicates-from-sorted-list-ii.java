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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        ListNode curr = dummy;

        ListNode ans = new ListNode(0);
        ListNode cpy = ans;

        while (curr != null) {
            boolean duplicateFound = false;

            while (curr.next != null && curr.val == curr.next.val) {
                duplicateFound = true;
                curr = curr.next;
            }
            if (!duplicateFound) {
                cpy.next = new ListNode(curr.val);
                cpy = cpy.next;
            }

            curr = curr.next;
        }

        return ans.next;
    }
}