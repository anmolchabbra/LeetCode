class NeighborSum {
    private int[][] grid;
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private int[][] diag = {{1,1}, {-1,-1}, {-1, 1}, {1, -1}};
    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }
    
    public int adjacentSum(int value) {
        int[] rowCol = search(value);
        if (rowCol == null) return 0;
        int sum = 0;
        for (int[] dir: dirs) {
            int r = rowCol[0] + dir[0];
            int c = rowCol[1] + dir[1];
            if (isCheck(r, c)) sum += grid[r][c];
        }
        return sum;
    }
    
    private boolean isCheck(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        return true;
    }
    
    public int diagonalSum(int value) {
        int[] rowCol = search(value);
        if (rowCol == null) return 0;
        int sum = 0;
        for (int[] dir: diag) {
            int r = rowCol[0] + dir[0];
            int c = rowCol[1] + dir[1];
            if (isCheck(r, c)) sum += grid[r][c];
        }
        return sum;
    }
    private int[] search(int v) {
        for (int i = 0; i < grid.length;  i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == v) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */