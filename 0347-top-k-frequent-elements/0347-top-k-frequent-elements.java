class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int newCount = map.get(nums[i]) + 1;

                map.put(nums[i], newCount);
                    
                
                
                bucket[newCount].add(nums[i]);
                
                //new ArrayList<Integer>().e
                
                bucket[newCount - 1].remove(Integer.valueOf(nums[i]));
                    
            } else {
                map.put(nums[i], 1);
                bucket[1].add(nums[i]);
            }
        }
        
        for (int i = 0; i <= nums.length; i++) {
            System.out.println(bucket[i]);
        }
        
        int[] ans = new int[k];
        
        int index = 0;
        
        for (int i = bucket.length - 1;  i >= 1; i--) {
           List<Integer> res = bucket[i];
            
            for (int j = 0; j < res.size() ; j++) {
                if (index >= k) {
                    break;
                }
                ans[index] = res.get(j);
                index++;
            }
        }
        
        return ans;
    }
}