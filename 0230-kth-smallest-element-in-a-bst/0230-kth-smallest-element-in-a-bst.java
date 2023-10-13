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
    int kSmallest = 0;
    int c = 0;
    public int kthSmallest(TreeNode root, int k) {
        pre(root, k);
        return kSmallest;
    }
    public void pre(TreeNode root,int k) {
        if (root == null) {
            return;
        }
        pre(root.left, k);
        if (++c == k) {
            kSmallest = root.val;
            return;
        }
        pre(root.right, k);
    }
}