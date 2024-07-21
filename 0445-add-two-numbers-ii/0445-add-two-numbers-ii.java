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
    private ListNode reverseList(ListNode l1) {
        ListNode prev = null;
        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = prev;
            prev = l1;
            l1 = temp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode result = new ListNode(0);
        ListNode ptr = result; //rest
        int carry = 0; // Intialize carry
        //until both aare not comppleted;
        while (l1 != null || l2 != null)  {
            int sum = 0 + carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1) ptr.next = new ListNode(carry);
        result.next = reverseList(result.next);
        return result.next;
    }
}