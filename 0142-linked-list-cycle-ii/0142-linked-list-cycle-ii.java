/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
//         // Initialize tortoise and hare pointers
//         ListNode tortoise = head;
//         ListNode hare = head;

//         // Move tortoise one step and hare two steps
//         while (hare != null && hare.next != null) {
//             tortoise = tortoise.next;
//             hare = hare.next.next;

//             // Check if the hare meets the tortoise
//             if (tortoise == hare) {
//                 break;
//             }
//         }

//         // Check if there is no cycle
//         if (hare == null || hare.next == null) {
//             return null;
//         }

//         // Reset either tortoise or hare pointer to the head
//         hare = head;

//         // Move both pointers one step until they meet again
//         while (tortoise != hare) {
//             tortoise = tortoise.next;
//             hare = hare.next;
//         }

//         // Return the node where the cycle begins
//         return hare;
        
        
        //Other way
        //Find list exist
        //If not-> return -1;
        //Ok-> if exist then find length of list // let k is len
        //Then give one pointer ahead start of k nodes;
        //so lets asumme total len of list = n + k
        // first is at (k) and second at 0,
        //so for first length remaing to cover are those n nodes
        //so in mean time both compleate n there at start of loop and I can return the start
        
        ListNode fast = head, slow = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) return null;
        
        //Find len 
        ListNode start = fast;
        int len = 0;
        while (fast != start) {
            len++;
            fast = fast.next;
        }
        
        while (len > 0) {
            fast = fast.next;
            len--;
        }
        
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
          
    }
}