class Solution {
    public int findDuplicate(int[] nums) {
        int num = -1;
        for (int i = 0; i < nums.length;) {
            int curr = nums[i];
            int currIndex = nums[i] - 1;
            if (i == nums[i] - 1) {
                i++;
                continue;
            }
            if (nums[i] ==  nums[currIndex]) {
                num = nums[i];
                break;
            }
            int temp = nums[currIndex];
            
            nums[currIndex] = nums[i];
            nums[i] = temp;
        }
        return num;
    }
}