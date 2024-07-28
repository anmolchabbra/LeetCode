/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private void preOrder(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("N,");
            return;
        }
        s.append(root.val).append(",");
        preOrder(root.left, s);
        preOrder(root.right, s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        preOrder(root, serialized);
        return serialized.toString();
    }

   private TreeNode buildTree(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        int value = Integer.parseInt(nodes[index[0]]);
        TreeNode root = new TreeNode(value);
        index[0]++;
        root.left = buildTree(nodes, index);
        root.right = buildTree(nodes, index);
        return root;
    }

    // Decodes your encoded data to tree
    public TreeNode deserialize(String data) {
        return buildTree(data.split(","), new int[]{0});
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;