class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        double maxAvg = Integer.MIN_VALUE;
        while (j < nums.length) {
            
            sum+= nums[j]; 
            
            if ((j - i + 1) >= k) {
                maxAvg = Math.max(maxAvg, sum);
                sum -= nums[i];
                i++;
            }
            
             
            j++;
        }
        return (double)maxAvg / k;
    }
}