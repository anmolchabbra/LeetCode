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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
         // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
       int qVal = q.val;

        
            // If both p and q are greater than parent
            if (pVal > parentVal && qVal > parentVal) {
                return lowestCommonAncestor(root.right, p, q);
            }// If both p and q are lesser than parent
            else if (pVal < parentVal && qVal < parentVal) {
                return lowestCommonAncestor(root.left, p, q);
            }// We have found the split point, i.e. the LCA node.
            else {
                return root;
            }
    }
}