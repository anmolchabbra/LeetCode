class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 1;
        int nextNonDup = 1;
        while (curr < nums.length) {
            if (nums[curr] != nums[nextNonDup - 1]) {
                nums[nextNonDup] = nums[curr];
                nextNonDup++;
            }
            curr++;
        }
        return nextNonDup;
    }
}