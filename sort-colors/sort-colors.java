class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, one = 0;
        int curr = 0;
        while (curr <= two) {
            if (nums[curr] == 1) curr++;
            else if (nums[curr] == 2) {
                int temp = nums[two];
                nums[two] = nums[curr];
                nums[curr] = temp;
               // curr++;
                two--;
            } else {
                int temp = nums[zero];
                nums[zero] = nums[curr];
                nums[curr] = temp;
                zero++;
                curr++;
            }
        }
    }
}