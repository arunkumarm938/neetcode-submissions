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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while( head != null){
            list.add(head);
            head=head.next;
        }
        head = list.get(0);
        int n = list.size();
        for(int i=1;i<=n/2;i++){
            ListNode next = list.get(n - i);
            head.next = next;
            head = next;
            next = list.get(i);
            head.next = next;
            head = next;
        }
        head.next = null;
    }
}
