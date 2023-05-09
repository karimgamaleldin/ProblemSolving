/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums , 0 , nums.length - 1);
    }
    public TreeNode helper (int[] nums , int i , int j){
        if(j < i) return null;
        else if (i == j) return new TreeNode(nums[i]);
        int mid = i + (j - i) / 2;
        return new TreeNode(nums[mid] , helper(nums , i , mid-1) , helper(nums , mid + 1 , j));
    }
}