class Solution {
    public void sortColors(int[] nums) {
        int l = 0, curr = 0, r = nums.length - 1;
        
        while (curr <= r) {
            if (nums[curr] == 0) {
                int temp = nums[l];
                nums[l++] = nums[curr];
                nums[curr++] = temp;
            } else if (nums[curr] == 2) {
                int temp = nums[r];
                nums[r--] = nums[curr];
                nums[curr] = temp;
            } else {
                curr++;
            }
        }
        
        
        
    }
}