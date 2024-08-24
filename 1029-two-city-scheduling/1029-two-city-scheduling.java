class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 100000;
            }
        }

        dp[0][0] = 0; // Base case: 0 cost when no one is assigned to either city

        for (int i = 0; i < 2 * n; i++) {
            for (int a = Math.min(n, i + 1); a >= 0; a--) {
                for (int b = Math.min(n, i + 1); b >= 0; b--) {
                    if (a > 0) {
                        dp[a][b] = Math.min(dp[a][b], dp[a - 1][b] + costs[i][0]);
                    }
                    if (b > 0) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][b - 1] + costs[i][1]);
                    }
                }
            }
        }

        return dp[n][n];
    }
}
