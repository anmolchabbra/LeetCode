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
// class Solution {
//      int depthF = -1;
//     TreeNode parent = null;
//     boolean isCousin = false;
//     public boolean isCousins(TreeNode root, int x, int y) {
//         helper(root, null, x, y, 0);
//         return isCousin;
        
//     }
   
//     private void helper(TreeNode root, TreeNode parent, int x, int y, int depth) {
//         if (root == null) return;
//         helper(root.left, root, x, y, depth + 1);
//         helper(root.left, root, x, y, depth + 1);
//     //    if (isCousin) return;
//         if (root.val == x || root.val == y) {
//             if (depthF == -1) {
//                 depthF = depth;
//                 parent = root;
//             } else {
//                 if ((depth == depthF) && (parent != root)) { isCousin = true; }
//             }
//         }
//     }
// }
class Solution {
    private int xDepth = -1, yDepth = -1;
    private TreeNode xParent = null, yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        // Start DFS traversal
        dfs(root, null, x, y, 0);
        // Check if both nodes are on the same depth but have different parents
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) return;

        // Check if the current node is one of the target nodes
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        } 
        if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }

        // Recursively search in left and right subtrees
        dfs(node.left, node, x, y, depth + 1);
        dfs(node.right, node, x, y, depth + 1);
    }
}
