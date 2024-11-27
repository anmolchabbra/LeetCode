class Solution {
    
//     Map<String, Integer> map = new HashMap<>();
    
//     public int maxUncrossedLines(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         return dfs(nums1, nums2, m , n);
//     }
    
//     private int dfs(int[] a, int[] b, int m, int n) {
//         if (m == 0 || n == 0) return 0;
//         String key = m + "-" + n;
//         //memo
//         if (map.containsKey(key)) return map.get(key);
//         if (a[m -1] == b[n - 1]) {
//             int ret = 1 + dfs(a, b, m - 1, n - 1);
//             map.put(key, ret);
//             return ret;
//         }
//         int b1 = dfs(a, b, m - 1, n);
//         int b2 = dfs(a, b, m, n - 1);
//         int max = Math.max(b1, b2);
//         map.put(key, max);
//         return max;
//     }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    
}