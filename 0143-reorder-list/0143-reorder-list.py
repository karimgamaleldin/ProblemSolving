# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        sec = slow.next
        sec = self.reverse(sec)
        
        dummy = curr = ListNode()
        while head and sec:
            curr.next = head
            head = head.next
            curr.next.next = sec
            sec = sec.next
            curr = curr.next.next
            
        curr.next = head
        head.next = None
            
        return dummy.next
            
        
    def reverse(self, head:ListNode) -> None:
        prev = None
        curr = head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev
        
        