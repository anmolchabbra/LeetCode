class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 1;
        int l = 0, r = 1;
        
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                nums[pos] = nums[r];
                r++;
                l++;
                pos++;
            }
        }
        
        return pos;
    }
}