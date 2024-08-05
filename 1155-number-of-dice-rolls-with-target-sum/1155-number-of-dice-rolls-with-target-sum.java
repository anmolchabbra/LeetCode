class Solution {
    long modulo = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rolls(n, k, target, dp);
    }
    
    private int rolls(int n, int k, int target, int[][] dp) {
        if (target < 0) {
            return 0;
        }
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        
        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + rolls(n - 1, k, target - i, dp)) % (int)modulo;
        }
        dp[n][target] = ways;
        return ways;
    }
}
