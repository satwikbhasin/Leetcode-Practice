class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode count = head;
        int totalNodes = 1;
        while (count.next != null) {
            totalNodes++;
            count = count.next;
        }

        k %= totalNodes;

        if (k == 0)
            return head;

        int newHeadPos = totalNodes - k;

        ListNode newTail = head;
        for (int i = 1; i < newHeadPos; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        count.next = head;

        return newHead;
    }
}
