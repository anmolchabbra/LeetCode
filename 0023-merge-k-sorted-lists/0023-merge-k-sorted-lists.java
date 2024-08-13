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
    public ListNode mergeKLists(ListNode[] lists) {
        //So two approaches to this.
        /*First is usig conventional merge sort
        which means merging tow list and each time 
        we go over n elements but to merge k list
        we are first are taking logk time so total would be n .logk
        how log k is eg ->> 8 -> 4 -> 2 -> 1
        second is priority queue and //a,azing approach
        for The comparison cost will be reduced to 
        O(logk) for every pop and insertion to priority queue. 
        But finding the node with the smallest value just costs 
    O(1) time. There are  N nodes in the final linked list.so tatoal comes to O(N logk) 
    */
//         ListNode head = new ListNode(0);
//         ListNode ptr = head;
//         PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
//         for (ListNode node : lists) {
//             if (node != null) {
//                 queue.add(node);
//             }
//         }
//         while (!queue.isEmpty()) {
//             ptr.next = queue.poll();
//             ptr = ptr.next;
//             if (ptr.next != null) {
//                 queue.add(ptr.next);
//             }
//         }
//         return head.next;
        
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ptr.next = queue.poll();
            ptr = ptr.next;
            if (ptr.next != null) {
                queue.add(ptr.next);
            }
        }
        return head.next;
    }
}