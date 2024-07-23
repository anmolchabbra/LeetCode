class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //YOu attempt to trythe sliding window but that would not work okay,
        //see you can reduce or increase window as you dont if removeing -ve or +postive
        //adding -ve or +ve
        //1) brute force is to find all subarrays and cal sum
        //2) smart way thrigh prefix
      // Approach 2: Store prefixes in hashmap
        Map<Integer, Integer> map = new HashMap<>();
        //why this? as left side of 0 the elemet prefix sum is 0
        map.put(0,1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reqd = sum - k;
            if (map.containsKey(reqd)) {
                res += map.get(reqd);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}