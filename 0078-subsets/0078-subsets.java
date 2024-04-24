class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, new ArrayList<>(), 0, ans);
        return ans;
    }
    
    private void subset(int[] nums, List<Integer> curr, int n, List<List<Integer>> ans) {
        if (n == nums.length) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        curr.add(nums[n]);
         subset(nums, curr , n + 1, ans);
            curr.remove(curr.size() - 1);
            subset(nums, curr, n + 1, ans);
       
    }
}