class Solution {
    int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (exist(board, word, i, j, 0)) {
                   return true;
               }
            }
        }
        return false;
    }
    
    
    
    public boolean exist(char[][] board, String word, int row, int col, int index) {
        if (index >= word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
           || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        boolean ans = false;
        
        for (int[] dir : dirs) {
            char c = board[row][col];
                
            board[row][col] = '*';

            ans = ans || exist(board, word, row + dir[0], col + dir[1], index + 1);

            board[row][col] = c;
        }
        return ans;
    }
}