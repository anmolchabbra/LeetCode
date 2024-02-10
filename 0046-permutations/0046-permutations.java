class Solution {
     List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        solve(nums, new ArrayList<Integer>());
        
        return ans;
    }
    
    public void solve(int[]nums, List<Integer> sol) {
        
        //base case;
        if (sol.size() >= nums.length) {
            
            ans.add(new ArrayList<>(sol));
            System.out.println(ans);
           return;
        }
        
        //choices
        for (int i = 0; i < nums.length; i++) {
            if (sol.contains(nums[i])) {
                continue;
            }
            //add
            sol.add(nums[i]);
            
            //make call
            solve(nums, sol);
            
            //backtrack
            sol.remove(sol.size() - 1);
            
        }
        
        return;
        
    }
}