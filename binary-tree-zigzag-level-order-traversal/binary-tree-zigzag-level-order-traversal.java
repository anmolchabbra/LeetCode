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
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> toPut = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = q.poll();
                
                toPut.add(first.val);
                
                if (first.left != null) {
                    q.offer(first.left);
                }
                if (first.right != null) {
                    q.offer(first.right);
                }
            }
            if (!leftToRight) Collections.reverse(toPut);
            leftToRight = !leftToRight;
            ans.add(toPut);
        }
        return ans;
    }
}