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
//Was not able to solve this one
//Intrestingly we don't have tp binary to decimal conversion can use bitwise operations
// << left shift and then add curr
class Solution {
   
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
        
    }
    
     public int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = (sum << 1) | root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
}