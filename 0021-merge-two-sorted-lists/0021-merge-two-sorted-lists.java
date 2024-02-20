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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode first = list1;
       ListNode second = list2;
       int firstSize = 0, secondSize = 0;
       ListNode head = new ListNode();
       ListNode tail = head;
       first = list1;
       second = list2;
       while (first != null && second != null) {
           if (first.val < second.val) {
               ListNode temp = first.next;
               tail.next = first;
               first.next = null;
               first = temp;
               tail = tail.next;
           } else {
               ListNode temp = second.next;
               tail.next = second;
               second.next = null;
               second = temp;
               tail = tail.next;
           }
       }
        
       if (second != null) {
            tail.next = second;
       }
        
        if (first != null) {
            tail.next = first;
        }
     
       return head.next;
    }
}