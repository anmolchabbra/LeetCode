class Solution {
    public void setZeroes(int[][] matrix) {
        Set<int[]> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(new int[] {i, j});
                }
            }
        }
        
        for (int[] array : rows) {
            
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[array[0]][j] = 0;
            }
             for (int j = 0; j < matrix.length; j++) {
                 matrix[j][array[1]] = 0;
             }
        }
//          it = cols.iterator();
        
        
//         while(it.hasNext()) {
//             int col = (Integer)it.next();
//             for (int j = 0; j < matrix.length; j++) {
//                 matrix[j][col] = 0;
//             }
//         }
    }
    
}