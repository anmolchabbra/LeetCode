class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        permute(nums, 0, new ArrayList<>(), ans, visited);
        return ans;
    }
    public void permute(int[] nums, int start, List<Integer> curr, List<List<Integer>> ans, boolean[] visited) {
        //base case
        if (start >= nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        //
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            curr.add(nums[i]);
            permute(nums, start + 1, curr, ans, visited);
            //backtrack
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}