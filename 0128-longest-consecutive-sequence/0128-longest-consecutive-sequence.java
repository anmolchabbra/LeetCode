class Solution {
    public int longestConsecutive(int[] nums) {
        //Using set for first storing values //good que
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int j = 1;
                while (set.contains(nums[i] + j)) {
                    j++;
                }
                maxLength = Math.max(maxLength, j);
            }
        }
        
        return maxLength;
    }
}