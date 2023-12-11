class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        int j = 0;
        int sum = nums[0];
        double maxAvg = Integer.MIN_VALUE;
        while (j < nums.length - 1) {
            if ((j - i + 1) == k) {
                double cal = (double)sum / k;
                System.out.println("Sum: " + sum + "Avg" + cal);
                maxAvg = Math.max(maxAvg, cal);
                sum -= nums[i];
                i++;
            }
            j++;
            sum+= nums[j];  
        }
        double cal = (double)sum / k;
            System.out.println("Sum: " + sum + "Avg" + cal);
                maxAvg = Math.max(maxAvg, cal);
        return maxAvg;
    }
}