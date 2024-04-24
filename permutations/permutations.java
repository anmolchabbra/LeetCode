class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, new ArrayList<>(), 0, ans);
        return ans;
    }
    
    private void permute(int[] nums, List<Integer> curr, int n, List<List<Integer>> ans) {
        if (n >= nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) continue;
            
            curr.add(nums[i]);
            
            permute(nums, curr, n + 1, ans);
            
            curr.remove(curr.size() - 1);
        }
    }
}