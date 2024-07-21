class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] ans = new int[n];
        int index = n - 1;
        while (l <= r) {
            int leftVal = Math.abs(nums[l]);
            int rightVal = Math.abs(nums[r]);
            if (leftVal > rightVal) {
                ans[index] = leftVal * leftVal;
                l++;
            } else {
                ans[index] = rightVal * rightVal;
                r--;
            }
            index--;
        }
        return ans;
    }
}