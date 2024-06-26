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
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        
        prev = null;
        
        return isValid(root);
        
    }
    
    public boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValid(root.left)) return false;
        
        if (prev != null && root.val <= prev) return false;
        
        prev = root.val;
        

        return isValid(root.right);
    }
}