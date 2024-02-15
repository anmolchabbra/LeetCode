class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int first = text1.length() + 1;
        int second = text2.length() + 1;
        dp = new int[first][second];
        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < first; i++) {
            for (int j = 1; j < second; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] =  1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] =  Math.max(dp[i - 1][j], dp [i][j - 1]);
                }
            }
        }
        
        return dp[first - 1][second - 1];
    }
    
    public int helper(String text1, String text2, int first, int second) {
        
        if (first <0 || second < 0) {
            return 0;
        }
        if (dp[first][second] != -1) {
            return dp[first][second];
        }
        if (text1.charAt(first) == text2.charAt(second)) {
            dp[first][second] =  1 + helper(text1, text2, first - 1, second - 1);
        } else {
            dp[first][second] =  Math.max(
                helper(text1, text2, first - 1, second), 
                helper(text1, text2, first, second - 1));
        }
        return dp[first][second];
    }
}