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
        Map<Node, Node> map = new HashMap<>();
        Node copy = new Node(0);
        Node ptr = copy;
        curr = head;
        while (curr != null) {
            Node toAdd = new Node(curr.val);
            ptr.next = toAdd;
            ptr = ptr.next;
             map.put(curr, ptr);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                ptr = map.get(curr);
                Node randomNode = curr.random;
                Node copyRandom = map.get(randomNode);
                ptr.random = copyRandom;
            }
            curr = curr.next;
        }
        return copy.next;
    }
}