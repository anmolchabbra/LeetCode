class Solution {

    int ans = 0;

    public int dfs(ArrayList<ArrayList<Integer>> graph, int u){

        ArrayList<Integer> adjNodes = graph.get(u);

        int count = 1;
        int lenSubtree = -1;

        boolean flag = true;


        for(Integer v : adjNodes){
            int currLenSubTree = dfs(graph,v);
            if(currLenSubTree!=lenSubtree && lenSubtree!=-1){
                flag = false;
            }else{
                lenSubtree = currLenSubTree;
            }

            
            count += currLenSubTree;
        }

        if(flag){
            ans++;
        }
        return count;
    }
    public int countGoodNodes(int[][] edges) {

        int n = edges.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        int indegree[] = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v= edges[i][1];

            int sm = Math.min(u,v);
            int m = Math.max(u,v);
            u=sm;
            v=m;

            if(indegree[v]==0){
                indegree[v]++;
                graph.get(u).add(v);
            }else{
                indegree[u]++;
                graph.get(v).add(u);

            }
        

        }

        // for(ArrayList<Integer> r : graph){
        //     for(Integer u : r){
        //         System.out.print(u+" ");
        //     }
        //     System.out.println();
        // }

        dfs(graph,0);
        return ans;
        
    }
}