# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = curr = ListNode()
        carry = 0
        while l1 and l2:
            val = l1.val + l2.val + carry
            carry = val // 10
            val = val % 10
            curr.next = ListNode(val)
            l1, l2, curr = l1.next, l2.next, curr.next
        curr.next = l1 or l2
        
        
        while curr.next:
            val = curr.next.val + carry
            carry = val // 10
            curr.next.val = val % 10
            curr = curr.next
            
        if carry:
            curr.next = ListNode(carry)
        return dummy.next
            