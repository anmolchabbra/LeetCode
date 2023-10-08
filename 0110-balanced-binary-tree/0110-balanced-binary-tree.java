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
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalance;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        //height(root.right, h1, h2);
        if (Math.abs(r- l) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(l, r);
    }
}