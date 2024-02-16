class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        
        int[] visited = new int[n];
        
        
        return dfs(adj, visited, source, destination);
    }
    
    boolean ans = true;
    
    public boolean dfs(List<List<Integer>> adj, int[] visited, int curr, int dest) {
        
        if (visited[curr] == 2) {
            System.out.println("Loop detected");
            return false;
        }
        
        if (curr == dest) {
             System.out.println("dest detected " + curr + " dest" + dest);
            if (adj.get(curr).size() > 0) return false;
            return true;
        }
        
        
        
        visited[curr] = 2;
        
        if (adj.get(curr).size() == 0) {
            if (curr == dest) return true;
            return false;
        }
    
        
                System.out.println("call on node size " + adj.get(curr).size());
        for (int i = 0; i < adj.get(curr).size(); i++) {
            if (visited[adj.get(curr).get(i)] != 1) {
                System.out.println("call on node " + adj.get(curr).get(i));
                boolean val = dfs(adj, visited, adj.get(curr).get(i), dest);
                System.out.println("Val" + val);
                ans = ans && val;
            }
        }
        
        visited[curr] = 1;
        
        return ans;
    }
}