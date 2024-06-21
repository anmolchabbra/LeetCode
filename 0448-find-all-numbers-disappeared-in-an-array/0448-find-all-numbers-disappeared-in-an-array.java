class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int newIndex = Math.abs(nums[i]) - 1;
            
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        
        return ans;
    }
}