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
    public class ListMetaData {
        ListNode node;
        int val;

        public ListMetaData(ListNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListMetaData> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new ListMetaData(lists[i], lists[i].val));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            ListMetaData metaData = pq.poll();
            current.next = metaData.node;
            current = current.next;

            if (metaData.node.next != null) {
                pq.add(new ListMetaData(metaData.node.next, metaData.node.next.val));
            }
        }

        return dummy.next;
    }
}