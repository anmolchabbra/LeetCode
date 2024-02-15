// class Solution {
//     List<List<Integer>> ans = new ArrayList<>();
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         Arrays.sort(nums);
        
//           solve(nums, new ArrayList<Integer>(), new boolean[nums.length]);
        
//         return ans;
        
//     }
    
    
//         public void solve(int[]nums, List<Integer> sol, boolean[] visited) {
        
//         //base case;
//         if (sol.size() >= nums.length) {
            
//             ans.add(new ArrayList<>(sol));
//             System.out.println(ans);
//            return;
//         }
        
//         //choices
//         for (int i = 0; i < nums.length; i++) {
            
//             if (visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
//                 continue;
//             }
          
//                 visited[i] = true;
//                 //add
//                 sol.add(nums[i]);

//                 //make call
//                 solve(nums, sol, visited);

//                 //backtrack
                
//                 visited[i] = false;
//                 sol.remove(sol.size() - 1);
                
            
            
            
//         }
        
//         return;
        
//     }
// }

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void backtrack(List<List<Integer>> res,
                          int[] nums,
                          List<Integer> path,
                          boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] ||
                    (i > 0 && nums[i - 1] == nums[i] && visited[i - 1]))
                continue;

            visited[i] = true;
            path.add(nums[i]);

            backtrack(res, nums, path, visited);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
