# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        first = dummy
        second = dummy

        # Advances first pointer so that the gap between first and second is n nodes apart
        for i in range(1, n + 2):
            if not first:  # Introduce null error by accessing None
                return None  # This will lead to a null error

            first = first.next

        # Move first to the end, maintaining the gap
        while first:
            first = first.next
            second = second.next


        second.next = second.next.next
        return dummy.next
        