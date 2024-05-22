/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode copy = head;
        while(head != null){
            int moves = 2;
            while(moves > 0){
                if(head.next != null){
                    head = head.next;
                    moves--;
                } else break;
            }
            if(moves == 0) copy = copy.next;
            else if(moves == 1) return copy.next;
            else if(moves == 2) return copy;
        }
        return new ListNode();
    }
}