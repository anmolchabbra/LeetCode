class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int comp = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                comp++;
                dfs(adjList, i, visited);
            }
        }
        return comp;
    }
    
    private void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) return;
        
        visited[node] = true;
        
        for (Integer i : graph.get(node)) {
            dfs(graph, i, visited);
        }
    }
}