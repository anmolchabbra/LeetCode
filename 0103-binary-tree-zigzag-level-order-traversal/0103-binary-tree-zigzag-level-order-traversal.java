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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> toAdd = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (leftToRight) {
                        toAdd.add(node.val);
                    } else {
                        toAdd.addFirst(node.val);
                    }
                    
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }
            ans.add(toAdd);
            toAdd = new LinkedList<>();
            leftToRight = !leftToRight;
        }
        return ans;
    }
}