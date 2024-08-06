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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Base case: If root is null, there is no successor
        if (root == null) {
            return null;
        }

        // If p's value is greater than or equal to the current node's value,
        // the successor must be in the right subtree (if it exists).
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            // Otherwise, the current node might be the successor,
            // but we need to check if there's a closer one in the left subtree.
            TreeNode leftSuccessor = inorderSuccessor(root.left, p);
            return (leftSuccessor != null) ? leftSuccessor : root;
        }
    }
}

//Optimal
// class Solution {
    
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
//         TreeNode successor = null;
        
//         while (root != null) {
            
//             if (p.val >= root.val) {
//                 root = root.right;
//             } else {
//                 successor = root;
//                 root = root.left;
//             }
//         }
        
//         return successor;
//     }
// }