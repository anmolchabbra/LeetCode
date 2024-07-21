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
    //Imp: Balanceed at each node //don't check just for root left and right compare,
    //that fails
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        isHeight(root);
        return isBalance;
    }
    
    private int isHeight(TreeNode root) {
        if (root == null) return 0;
        int l = 1 + isHeight(root.left);
        int r = 1 + isHeight(root.right);
        if (Math.abs(r - l)> 1) {
            isBalance = false;
        }
        return Math.max(l, r);
    }
}