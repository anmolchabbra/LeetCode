class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0, rightSum = sum, pivotIndex = -1;
        if (leftSum == rightSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            leftSum = leftSum + nums[i - 1];
            if (rightSum == leftSum) {
                pivotIndex = i;
                break;
            }
        }
        return pivotIndex;
    }
}