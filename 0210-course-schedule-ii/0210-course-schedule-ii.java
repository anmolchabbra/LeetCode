class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            
        }
        
        int[] visited = new int[numCourses];
        
        int[] ans = new int[numCourses];
        
        int index = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(adj, visited, i, ans)) {
                return new int[] {};
            }
        }
        
        return ans;       
        
    }
    int index = 0;
    public boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr, int[] ans) {
        
        if (visited[curr] == 1) {
            return false;
        }
        
        if (visited[curr] == 2) {
            System.out.println("Loop detected at " + curr);
            return true;
        }
        
        visited[curr] = 2;
        
        for (int i = 0; i < adj.get(curr).size(); i++) {
            if (visited[adj.get(curr).get(i)] != 1) {
                if (isCyclic(adj, visited, adj.get(curr).get(i), ans)) {
                    return true;
                } else {
                    
                }
            }
        }
        
        System.out.println("Curr" + curr);
        ans[index] = curr;
        index++;
        visited[curr] = 1;
        
        return false;
        
    }
}