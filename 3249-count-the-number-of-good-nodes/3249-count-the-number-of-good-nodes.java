import java.util.*;

class Solution {
    int goodNodes = 0;

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>(n);
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] subtreeSize = new int[n];
        Arrays.fill(subtreeSize, -1);
        
        // Start DFS from the root node (0)
        dfs(adj, 0, -1, subtreeSize);
        
        return goodNodes;
    }
    
    private int dfs(List<List<Integer>> adj, int node, int parent, int[] subtreeSize) {
        // Initialize the subtree size for the current node
        if (subtreeSize[node] != -1) {
            return subtreeSize[node];
        }
        
        // Base case for leaf nodes
        if (adj.get(node).size() == (parent == -1 ? 0 : 1)) {
            subtreeSize[node] = 1;
            goodNodes++;
            return 1;
        }
        
        List<Integer> childSizes = new ArrayList<>();
        int totalSize = 1; // Size including itself
        
        // Calculate subtree sizes for children
        for (int child : adj.get(node)) {
            if (child == parent) continue;
            int childSize = dfs(adj, child, node, subtreeSize);
            childSizes.add(childSize);
            totalSize += childSize;
        }
        
        // Check if all child subtree sizes are the same
        boolean isGoodNode = true;
        if (childSizes.size() > 1) {
            int firstSize = childSizes.get(0);
            for (int size : childSizes) {
                if (size != firstSize) {
                    isGoodNode = false;
                    break;
                }
            }
        }
        
        if (isGoodNode) {
            goodNodes++;
        }
        
        subtreeSize[node] = totalSize;
        return totalSize;
    }
}
