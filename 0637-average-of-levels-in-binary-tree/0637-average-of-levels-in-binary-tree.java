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
    
    List<Double> ans = new ArrayList<>();
    
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
    
        
        while (!queue.isEmpty()) {
            
            int total = 0;
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode got = queue.poll();
                
                sum += got.val;
                
                if (got.left != null) {
                    queue.add(got.left);
                }
            
                if (got.right != null) {
                    queue.add(got.right);
                }
                total++;
            }
            
            ans.add(sum / total);
            sum = 0;
        }
        
        return ans;
    }
}