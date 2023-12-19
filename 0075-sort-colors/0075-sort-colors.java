class Solution {
    public void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public void sortColors(int[] nums) {
        int curr = 0, p0 = 0, p2 = nums.length - 1;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(curr, p0, nums);
                curr++;
                p0++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(curr, p2, nums);
                //curr++;
                p2--;
            }
        }
    }
}