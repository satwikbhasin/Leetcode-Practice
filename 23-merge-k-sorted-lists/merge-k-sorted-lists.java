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
    private class ListState {
        int currVal;
        ListNode pointer;

        ListState(ListNode pointer) {
            this.pointer = pointer;
            this.currVal = this.pointer.val;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListState> pq = new PriorityQueue<>((a, b) -> (a.currVal - b.currVal));

        ListNode curr = new ListNode(0);
        ListNode ans = curr;

        for (ListNode list : lists) {
            if (list != null) {
                ListState listState = new ListState(list);
                pq.offer(listState);
            }
        }

        while (!pq.isEmpty()) {
            ListNode currSmallest = pq.poll().pointer;
            curr.next = currSmallest;
            curr = curr.next;
            currSmallest = currSmallest.next;
            if (currSmallest != null) {
                ListState updatedState = new ListState(currSmallest);
                pq.offer(updatedState);
            }
        }

        return ans.next;
    }
}