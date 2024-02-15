class Solution {
   
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        return dp[n];
    
        
    }
    
    //int minCount = Integer.MAX_VALUE;
    
    //Recursive bruteforce
    
//     public int numSquaresHelper(int n, int count) {
        
//         if (n == 0) {
//              System.out.println("C" + count);
//             return count;
//         }
//         if (n < 0) {
//             return Integer.MAX_VALUE;
//         }
        
//         for (int i = 1; i * i <= n; i++) {
//             int a = numSquaresHelper(n - (i * i), count + 1);
//             System.out.println("A" + a);
//             minCount = Math.min(minCount, a);
            
//         }
//         System.out.println("min count" + minCount);
//         return minCount;
        
//     }
}