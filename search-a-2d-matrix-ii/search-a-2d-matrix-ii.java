class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1, c = 0;
        while (c <= matrix[0].length - 1  && r >= 0) {
            
            System.out.println("Row" + r + "  " + "Col" + c);
            if (matrix[r][c] == target) return true;
            
            if (target >= matrix[r][c] && target <= matrix[r][matrix[0].length - 1]) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }
}