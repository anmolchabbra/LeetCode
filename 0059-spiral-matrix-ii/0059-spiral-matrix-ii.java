class Solution {
    public int[][] generateMatrix(int len) {

        if (len == 1) {
            int[][] a = {{1}};
            return a;
        }
        int[][] ans = new int[len][len];
        int top = 0, bottom  = len - 1, left = 0, right = len - 1;
        int n = 1;
        
        while(top <= bottom && left <= right) {
            
            for (int i = left; i <= right; i++) {
                ans[top][i] = n;
                n++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = n;
                n++;
            }
            right--;
            for (int i = right; i >=left; i--) {
                ans[bottom][i] = n;
                n++;
            }
            bottom--;
            for (int i = bottom; i >=top; i--) {
                ans[i][left] = n;
                n++;
            }
            left++;
        }
        return ans;
    }
}