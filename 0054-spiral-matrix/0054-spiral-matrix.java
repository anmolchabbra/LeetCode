class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        
        while (l < r && up < down) {
           System.out.println("l" + l + "r" + r + "up" + up + "down" + down);
        
            for (int i = l; i <= r; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l; i--) {
                System.out.println("val" + matrix[down][r] +" " + i);
                 System.out.println("ans" + ans);
                ans.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][l]);
            }
            l++;
           
            
        }
        
         if (l == r && up == down) {
            ans.add(matrix[up][l]);
        } 
        if (l < r && up == down) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[up][i]);
            }
        }
        if (up < down && l == r) {
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][l]);
            }
        }
        
        return ans;
    }
}