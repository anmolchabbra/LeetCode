class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        
        for (int r = 1; r < nums.length;) {
            if (nums[l] == 0 && nums[r] != 0) {
                //sWAP
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
                r++;
            } else if (nums[r] == 0 && nums[l] != 0) {
                l = r;
                r = l + 1;
            } else
                r++;
        }
    }
}