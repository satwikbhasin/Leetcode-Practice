class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode count = head;
        int totalNodes = 0;

        while (count != null) {
            totalNodes++;

            // reached the end
            if (count.next == null) {
                if (k % totalNodes == 0)
                    return head;
                count.next = head;
                break;
            }

            count = count.next;
        }

        int newHeadPos = totalNodes - (k % totalNodes);

        ListNode afterHead = head;
        ListNode afterTail = afterHead;

        for (int i = 1; i < newHeadPos; i++) {
            afterTail = afterTail.next;
        }

        ListNode beforeHead = afterTail.next;
        ListNode beforeTail = beforeHead;
        afterTail.next = null;

        for (int i = 0; i < totalNodes - newHeadPos - 1; i++) {
            beforeTail = beforeTail.next;
        }
        beforeTail.next = afterHead;

        return beforeHead;
    }
}
