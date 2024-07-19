class Solution {
    public int missingElement(int[] nums, int k) {
       
        // O(n) solution
//         int n = nums.length - 1;
        
//         for (int i = 1; i < nums.length; i++) {
//             int range = nums[i] - nums[i - 1] - 1;
//             if (k <= range) {
//                 return nums[i - 1] + k;
//             }
//             k -= range;
//         }
//         return nums[n] + k;
        
        //Smarter way is using binary search
        
        int l = 0, r = nums.length - 1;
        int n = nums.length;
        int missingNumAmt = nums[n - 1] - nums[0] - (n-1);
        if (missingNumAmt < k) {
            return nums[n - 1] + k - missingNumAmt;
        }
        while (l < r) {
            
            int mid = l + (r - l) / 2;
            
            int range = nums[mid] - nums[0] - mid;
            
            if (range < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
          return nums[0] + l + k - 1;
    }
}