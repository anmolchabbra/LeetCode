class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        Iterator it = rows.iterator();
        
        while(it.hasNext()) {
            int row = (Integer)it.next();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
         it = cols.iterator();
        
        
        while(it.hasNext()) {
            int col = (Integer)it.next();
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
    }
    
}