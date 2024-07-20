/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Two pointer approach
        /* 
        Calculate N; the length of list A.
        Calculate \U0001d440; the length of list B.
        Set the start pointer for the longer list.
        Step the pointers through the list together.
        */
        int firstListLen = 0;
        ListNode temp = headA;
        while (temp != null) {
            firstListLen++;
            temp = temp.next;
        }
        int secondListLen = 0;
        temp = headB;
        while (temp != null) {
            secondListLen++;
            temp = temp.next;
        }
        int diff = 0;
        if (firstListLen > secondListLen) {
            diff = firstListLen - secondListLen;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            diff = secondListLen - firstListLen;
             while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
        
    }
}