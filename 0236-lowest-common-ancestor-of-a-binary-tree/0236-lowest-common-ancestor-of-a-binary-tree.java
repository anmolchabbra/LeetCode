/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        return left == null ? right : left;
    }
    
//     public boolean lca(TreeNode curr, TreeNode p, TreeNode q) {
//         if (curr == null) {
//             return false;
//         }
        
//         if (curr.val == p.val) {
            
//         }
        
//         int left = lca(curr.left, p, q) ? 1 : 0;
        
//         int right = lca(curr.right, p, q) ? 1 : 0;
        
        
//     }
}