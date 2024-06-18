class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode prev = null;
        ListNode curr = before.next;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        before.next.next = curr;
        before.next = prev;

        return dummy.next;
    }
}
