class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy =  Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = 0, end = nums.length - 1;
    
        while (start < end) {
            boolean flag = false;
            if (nums[start] == copy[start]) {
                flag = true;
                start++;
            }
            if (nums[end] == copy[end]) {
                flag = true;
                end--;
            }
            if (!flag) return (end - start + 1);
        }
        return 0;
      
    }
}