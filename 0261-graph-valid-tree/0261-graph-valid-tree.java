class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        if (isCycle(adjList, 0, -1, visited)) {
                return false;
        }
         System.out.print("no cycle");
        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }

    private boolean isCycle(List<List<Integer>> graph, int curr, int prev, boolean[] visited) {
        if (visited[curr]) return true;
        visited[curr] = true;
        for (Integer i : graph.get(curr)) {
            //is parent
            if (prev == i) continue;
            if (isCycle(graph, i, curr, visited)) {
                System.out.println("here");
                return true;
            }
        }
        return false;
    }
}
