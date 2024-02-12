class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(nums, new ArrayList<Integer>(), ans, 0 );
        
        return ans;
    }
    public void helper(int[] nums, List<Integer> toAdd, List<List<Integer>> ans, int index) {
        
        
        //base case
        if (index >= nums.length) {
            ans.add(new ArrayList<>(toAdd));
            toAdd = new ArrayList<>();
            return;
        }
        
        toAdd.add(nums[index]);
        
        //take
        helper(nums, toAdd, ans, index + 1);
        
        
        //backtrack
        toAdd.remove(toAdd.size() - 1);
        
        //not take
        helper(nums, toAdd, ans, index + 1);
        
        
    }
}