class Solution {
    public boolean circularArrayLoop(int[] nums) {
        //
        Set<Integer> set = new HashSet<>();
        int m = nums.length;
        for (int i = 0; i < m; i++) {
            boolean forward = nums[i] >= 0 ? true: false;
            int slow = i, fast = i;
            
            while (true) {
                
                slow = getNext(slow, forward, nums, m);
                fast = getNext(fast, forward, nums, m);
                if (slow == -1 || fast == -1) {
                    break;
                }
                fast = getNext(fast, forward, nums, m);
                
                if (fast == -1 || slow == -1 || slow == fast) break;
              
                
            }    
            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    private int getNext(int curr, boolean dir, int[] nums, int size) {
        boolean forward = nums[curr] >= 0 ? true : false;
        int nextIndex = (curr + nums[curr]) % size;
        if (forward != dir) return -1;
        nextIndex = nextIndex < 0 ? nextIndex + size : nextIndex;
        if (curr == nextIndex) return -1; //One element cycle
        return nextIndex;
    }
}