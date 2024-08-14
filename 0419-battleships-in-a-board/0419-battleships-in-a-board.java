class Solution {
    public int countBattleships(char[][] board) {
        int battleShips = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j]= '.';
                    battleShips++;
                    int r = i;
                    int c = j;
                    int k = 1;
                    boolean isCol = false;
                    while (i + k < m && board[i  + k][j] == 'X') {
                        board[i + k][j] = '.';
                        k++;
                    }
                    k = 1;
                    while (j + k < n  && board[i][j + k] == 'X') {
                        isCol = true;
                        board[i][j + k] = '.';
                        k++;
                    }
                    if (isCol)
                        j = k ;
                    
                }
            }
    }
        return battleShips;
    }
}