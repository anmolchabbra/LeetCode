class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        
        int row = 0, col = 0;
        
        if (m * n != original.length) {
            return new int[][] {};
    }
        
        for (int i = 0; i < original.length; i++) {
            if (i != 0 && i % n == 0) {
                row++;
                col = 0;
            }
            ans[row][col] = original[i];
            col++;
        }
        
        return ans;
    }
}