class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0, i = 0;
        int sum = 0;
        int minLen = nums.length + 1;
        while (j < nums.length) {
            sum += nums[j];
            if (sum >= target) {
                
                while (sum >= target && i <= j) {
                    minLen = Math.min(minLen, (j - i + 1));
                    sum -= nums[i];
                    i++;
                }
            } 
            j++;
        }
         return minLen == nums.length + 1 ? 0 : minLen;
     //   if (sum < target) return 0;
       
    }
}

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int left = 0, right = 0, sumOfCurrentWindow = 0;
//         int res = Integer.MAX_VALUE;

//         for(right = 0; right < nums.length; right++) {
//             sumOfCurrentWindow += nums[right];

//             while (sumOfCurrentWindow >= target) {
//                 res = Math.min(res, right - left + 1);
//                 sumOfCurrentWindow -= nums[left++];
//             }
//         }

//         return res == Integer.MAX_VALUE ? 0 : res;
//     }
// }