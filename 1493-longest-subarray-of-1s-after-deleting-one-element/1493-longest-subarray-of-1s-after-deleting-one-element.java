class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int zeroCount = 0, longestWindow = 0;
        while (j < nums.length) {
            zeroCount += nums[j] == 0 ? 1 : 0;
            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            longestWindow = Math.max(longestWindow, j - i);
            j++;
        }
        return longestWindow;
    }
}