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
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode revListHead = reverseList(slow);
        
        //Reorder
        
        //Please draw to undestnd
        //for 1,2,3,4,5
        //now mid is at 3
        //and we reverse so ereverse one is 5,4,3-> null,
        //first one - 1,2,3-> null
        //3 becomes common,
        //so when second.next mean we reached last menans they connect at 3
        ListNode first = head, second = revListHead, tmp;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
        
    }
    
    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}