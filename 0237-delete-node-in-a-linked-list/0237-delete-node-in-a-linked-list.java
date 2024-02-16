/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        //put next value to current
        node.val = nextNode.val;
        //curr node tp point next of nextNode
        node.next = nextNode.next;
        //make nextNode to point null
        nextNode.next = null;
    }
}