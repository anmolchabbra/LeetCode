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
    int ways = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countNodes(root, root.val);
        return ways;
    }
    
    public void countNodes(TreeNode node, int preMax) {
        
        if (node == null) {
            return;
        }
        
        if (node.val >= preMax) {
            System.out.println("Curre " + node.val);
            ways++;
            
        }
        
        countNodes(node.left, Math.max(node.val, preMax));
        countNodes(node.right, Math.max(node.val, preMax));
    }
}