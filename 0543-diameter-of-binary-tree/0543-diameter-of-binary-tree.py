# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            if not root:
                return 0, 0
            left_curr, left_max = dfs(root.left)
            right_curr, right_max = dfs(root.right)
            path = left_curr + right_curr 
            return max(left_curr, right_curr) + 1, max(left_max, right_max, path)
        return dfs(root)[1]