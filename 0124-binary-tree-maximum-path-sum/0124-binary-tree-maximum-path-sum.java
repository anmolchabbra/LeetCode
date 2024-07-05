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
    private static int globalMaximumSum;

  public static int maxPathSum(TreeNode root) {
    globalMaximumSum = Integer.MIN_VALUE;
    findMaximumPathSumRecursive(root);
    return globalMaximumSum;
  }

  private static int findMaximumPathSumRecursive(TreeNode currentNode) {
    if (currentNode == null) {
      return 0;
    }

    int maxPathSumLeft = findMaximumPathSumRecursive(currentNode.left);
    int maxPathSumRight = findMaximumPathSumRecursive(currentNode.right);

    // Ignore paths with negative sums, since we need to find the maximum sum
    // we should ignore any path which has an overall negative sum
    maxPathSumLeft = Math.max(maxPathSumLeft, 0);
    maxPathSumRight = Math.max(maxPathSumRight, 0);

    // Maximum path sum at the currentNode will be equal to the sum from the
    // left subtree + the sum from the right subtree + value of the currentNode
    int localMaximumSum = maxPathSumLeft + maxPathSumRight + currentNode.val;

    // Update the globalMaximumSum
    globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

    // Maximum sum of any path from the currentNode will be equal to the maximum
    // of the sums from left or right subtree plus the value of the currentNode
    return Math.max(maxPathSumLeft, maxPathSumRight) + currentNode.val;
  }

}