class Solution {
    //int res = 0;
    double MODULO = 1e9 + 7;
    
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n + 1][target + 1];
        helper(n, k, target, dp);
       return dp[n][target];
    }
    
    private int helper(int n, int k, int target, Integer[][] dp) {
        if (n < 0 || target < 0) {
            return 0;
        }
        if (n <= 0 && target > 0) {
            return 0;
        }
        if (n > 0 && target <= 0) {
            return 0;
        }
         if ( dp[n][target] != null) {
            return dp[n][target];
        }
        if (target == 0 && n == 0) {
            return 1;
        }
        int res = 0;
        if (target > 0  && n > 0) {
            for (int i = 1; i <= k; i++) {
                res += helper(n - 1, k, target - i, dp);
                res = res % (int)MODULO;
                dp[n][target] = res;
            }
        }
        return dp[n][target] = res;
    }
}