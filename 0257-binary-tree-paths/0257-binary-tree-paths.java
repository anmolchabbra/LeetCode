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
    List<String> ans = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTree(root, "");
        return ans;
    }
    public void binaryTree(TreeNode root, String toAdd) {
        if (root == null) {
            return;
        }
        toAdd += ("" + root.val);
        toAdd += "->";
        
        binaryTree(root.left, toAdd);
        binaryTree(root.right, toAdd); 
        
        if (root.left == null && root.right == null) {
            String toPut = "";
            for (int i = 0; i < toAdd.length() - 2; i++) {
                toPut += (toAdd.charAt(i));
            }
            ans.add(toPut);
            toAdd = "";
        }
    }
}