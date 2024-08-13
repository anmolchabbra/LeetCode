// class Solution {
//     public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
//         //wrong apporach as I'm accountiwng fot the minumum
// //         int[][] pathDis = new int[n][2];
// //        // pathDis[]
// //         for (int i = 1; i < n; i++) {
// //             pathDis[i][0] = i;
// //             pathDis[i][1] = i - 1;
// //         }
// //         int[] res = new int[queries.length];
// //         //Arrays.fill(pathDis, Integer.MAX_VALUE);
// //         for (int i = 0; i < queries.length; i++) {
// //             int u = queries[i][0];
// //             int v = queries[i][1];
// //             if (pathDis[v][0] > pathDis[u][0] + 1) {
// //                 pathDis[v][0] = pathDis[u][0] + 1;
// //                 pathDis[v][1] = u;
// //             System.out.println("updatedfor : " + v + "dis " +  pathDis[v][0] + "Source" + u);
// //             }
            
// //              System.out.println("start" + (v + 1));
            
// //             for (int j = v + 1; j < n; j++) {
// //                 int prevSource = pathDis[j][1];
// //                 if (prevSource == v) {
                   
// //                     pathDis[j][0] = Math.min(pathDis[j][0], pathDis[v][0] + 1);
                    
// //                      System.out.println("updatedfor : " + j + "dis " +  pathDis[j][0]);
// //                 } else {
// //                      System.out.println("updatedfor : " + j + "dis " +  pathDis[j][0] + "s: " + prevSource);
// //                     int curr = pathDis[v][0] + (j - v);
// //                     int prev =  pathDis[prevSource][0] +1;
// //                     if (curr <= prev) {
// //                         pathDis[j][0] = curr;
// //                         pathDis[j][1] = v;
// //                     } else {
// //                         pathDis[j][0] = prev;
// //                     }
// //                   //   pathDis[j][0] = Math.min(pathDis[j][0], pathDis[v][0] + (j - v));
// //                 }
// //             }
// //             res[i] = pathDis[n - 1][0];
// //         }
// //         return res;
//     }
// }

import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Initialize the graph with the direct roads
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});  // Road from city i to i+1 with distance 1
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(new int[]{v, 1});  // Add the new road from u to v with distance 1

            // Use Dijkstra's algorithm to find the shortest path from city 0 to city n-1
            res[i] = dijkstra(graph, n);
        }

        return res;
    }

    private int dijkstra(List<List<int[]>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});  // Start from city 0 with distance 0

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentDist = current[1];

            // if (currentDist > dist[u]) {
            //     continue;
            // }

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return dist[n - 1];
    }
}
