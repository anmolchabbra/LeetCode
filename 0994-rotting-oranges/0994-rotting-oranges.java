class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int countFresh = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        
        if (countFresh == 0) return 0;
        
        int time = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++)  {
                int[] rottenPos = q.remove();
                for (int[] dir : dirs ) {
                    int row = rottenPos[0] + dir[0];
                    int col = rottenPos[1] + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 
                        && col < grid[0].length && grid[row][col] == 1) {
                        
                        
                        grid[row][col] = 2;
                        countFresh--;
                        
                        q.add(new int[] {row, col});
                    }
                }
            }
            
            time++;
        }
        
        return countFresh == 0 ? time - 1 : -1;
        
    }
}