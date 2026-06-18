/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node prev = null;
        Node newCurr = null;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = null;
        while(curr != null){
            Node node = new Node(curr.val);
            if(newCurr != null){
                newCurr.next = node;
                newCurr = newCurr.next;
            }else{
                newCurr = node;
                newHead = newCurr;
            }
            map.put(curr, node);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node newNode = map.get(curr);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return newHead;
    }
}
