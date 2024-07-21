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
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = list1;
                    tail = list1;
                } 
                tail.next = list1;
                list1 = list1.next;
                
            } else {
                if (head == null) {
                    head = list2;
                    tail = list2;
                }
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        // ListNode temp = head;
        // while (temp != null) {
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        return head.next;
    }
}