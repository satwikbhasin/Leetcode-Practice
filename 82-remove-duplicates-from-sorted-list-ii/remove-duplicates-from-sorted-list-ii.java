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
        ListNode curr = head;

        ListNode ans = new ListNode(0);
        ListNode ansCurr = ans;

        while (curr != null) {
            boolean duplicateFound = false;

            while (curr.next != null && curr.val == curr.next.val) {
                duplicateFound = true;
                curr = curr.next;
            }
            if (!duplicateFound) {
                ansCurr.next = new ListNode(curr.val);
                ansCurr = ansCurr.next;
            }

            curr = curr.next;
        }

        return ans.next;
    }
}