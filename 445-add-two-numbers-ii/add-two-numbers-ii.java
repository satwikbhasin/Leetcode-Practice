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
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);

        ListNode curr = new ListNode(0);
        ListNode ans = curr;

        int sum = 0;
        int carry = 0;

        while (r1 != null || r2 != null || carry != 0) {
            sum = carry;
            if (r1 != null) {
                sum += r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                sum += r2.val;
                r2 = r2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return reverseList(ans.next);
    }
}