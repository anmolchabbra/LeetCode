class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        int rows = matrix.length;
        int col = matrix[0].length;
        
        int r = rows - 1, c = 0;
        
        while (r >= 0 && c < col ) {
            if (matrix[r][c] == target) return true;
            
            if (target < matrix[r][c]) r--;
            else c++;
        }
        return false;
    }
}