class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int maxSequence = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int j = 1;
                while (set.contains(nums[i] + j)) {
                    j++;
                }
                maxSequence = Math.max(maxSequence, j);
            }
        }
        return maxSequence;
    }
}