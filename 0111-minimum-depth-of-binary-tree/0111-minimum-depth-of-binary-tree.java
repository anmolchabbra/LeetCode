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

    //DFS Solution
    
//     public int minDepth(TreeNode root) {
//         if (root == null) return 0;
//         if (root.right == null) {
//             return 1 + minDepth(root.left);
//         } else if (root.left == null) {
//             return 1 + minDepth(root.right);
//         }
        
//         return 1 +  Math.min(minDepth(root.left), minDepth(root.right));
        
//     }
    
    //BFS Solution
     public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
     
        Queue<TreeNode> q = new LinkedList<TreeNode>();
         
        q.add(root);
         
        int depth = 1;
         
         while (!q.isEmpty()) {
             
             int size = q.size();
             
             while (size > 0) {
                 
                  size--;
                 
                 TreeNode get = q.poll();
                 
                 if (get == null) continue;
                 
                 if (get.left == null && get.right == null) return depth;
                 
                 
                 q.add(get.left);
                 
                 q.add(get.right);
                 
                
             }
             depth++;
             
         }
         
         return -1;
        
    }

}