class Solution {
      Set<Integer> cols = new HashSet<>();
    Set<Integer> postDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        dfs(n, ans, 0, new ArrayList<>());
        return ans;
    }
    
    private void dfs(int n, List<List<String>> ans, int row, List<String> curr) {
        if (row == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                placeQueen(row, col, curr, n);
                dfs(n, ans, row + 1, curr);
                removeQueen(row, col, curr);
            }
        }
    }
    
    private boolean isSafe(int row, int col) {
        // Check if placing a queen at (row, col) is valid
        return !cols.contains(col) && !postDiag.contains(row + col) && !negDiag.contains(row - col);
    }
    
    private void placeQueen(int row, int col, List<String> curr, int n) {
        // Add the queen to the board and mark the positions
        cols.add(col);
        postDiag.add(row + col);
        negDiag.add(row - col);
        
        // Build the row string with a queen at the specified column
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        curr.add(sb.toString());
    }
    
    private void removeQueen(int row, int col, List<String> curr) {
        // Remove the queen from the board and unmark the positions
        cols.remove(col);
        postDiag.remove(row + col);
        negDiag.remove(row - col);
        curr.remove(curr.size() - 1);
    }
//      private void dfs(int n, List<List<String>> ans, int row, List<String> curr) {
//         if (row == n) {
//             ans.add(new ArrayList<>(curr));
//             return;
//         }
        
//         for (int col = 0; col < n; col++) {
//             // Check if the current position is under attack
//             if (cols.contains(col) || postDiag.contains(row + col) || negDiag.contains(row - col)) {
//                 continue;
//             }
            
//             // Choose
//             cols.add(col);
//             postDiag.add(row + col);
//             negDiag.add(row - col);
            
//             // Build the row string
//             StringBuilder sb = new StringBuilder();
//             for (int i = 0; i < n; i++) {
//                 if (i == col) {
//                     sb.append('Q');
//                 } else {
//                     sb.append('.');
//                 }
//             }
//             curr.add(sb.toString());
            
//             // Explore
//             dfs(n, ans, row + 1, curr);
            
//             // Un-choose (Backtrack)
//             cols.remove(col);
//             postDiag.remove(row + col);
//             negDiag.remove(row - col);
//             curr.remove(curr.size() - 1);
//         }
//     }
}