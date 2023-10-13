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
    int count = 1;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root.left, root);
        helper(root.right, root);
        return count;
    }
    
    public void helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }
        if (root.val >= prev.val) {
            ++count;
            helper(root.left, root);
            helper(root.right, root);
        } else {
            helper(root.left, prev);
            helper(root.right, prev);
        }
    }
}