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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        ListNode prev = null;
        curr = head;
        while(len > n){
            prev = curr;
            curr = curr.next;
            len--;
        }
        if(prev != null){
            prev.next = curr.next;
        }else{
            head = head.next;
        }
        return head;
    }
}
