class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] res = new int[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] {i, j, 0});
                    mat[i][j] = 2;
                }
            }
        }
        
        int[][] dirs = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] front = queue.remove();
            int r = front[0];
            int c = front[1];
            int steps = front[2];
            
            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                //System.out.println("Steps at row " + newR + " col" + newC + "mat" + mat[newR][newC] +  " steps:" + (steps+ 1));
                if (newR < 0 || newR >= m || newC < 0 || newC >= n || mat[newR][newC] == 2) {
                    continue;
                }
                //System.out.println("Steps at row " + newR + " col" + newC + " steps:" + (steps+ 1));
                res[newR][newC] = steps + 1;
                queue.add(new int[] {newR, newC, steps + 1});
                mat[newR][newC] = 2;
                
            }
        }
        
        return res;
    }
}