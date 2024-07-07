class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int start = i + 1;
            int end = nums.length - 1;
            int target = -nums[i];
            
            while (start < end) {
                int currSum = nums[start] + nums[end];
                if (currSum == target) {
                    List<Integer> toAdd = new ArrayList<>();
                    toAdd.add(nums[i]);
                    toAdd.add(nums[start]);
                    toAdd.add(nums[end]);
                    ans.add(toAdd);
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                     while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                    end--;
                } else if (currSum > target) {
                    end--;
                } else {
                    start++;  
                }
            }
        }
        
        return ans;
    }
}