# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root)
        return self.flag
    
    def helper(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return 0
        left, right = self.helper(root.left) + 1, self.helper(root.right) + 1
        if abs(left - right) > 1:
            self.flag = False
        return max(left, right)