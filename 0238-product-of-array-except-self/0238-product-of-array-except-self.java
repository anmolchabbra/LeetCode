class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        int product = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if ((i - 1) >= 0) {
               product = product * nums[i - 1];
            }
            ans[i] = product;
        }
        
        
        product = 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * product;
            product *= nums[i];
        }
        
        return ans;
    }
}