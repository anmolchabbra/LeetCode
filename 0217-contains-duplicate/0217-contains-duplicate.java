class Solution {
    public boolean containsDuplicate(int[] nums) {
        //Creating a set to store unique
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}