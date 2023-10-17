class KthLargest {
    final PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) add(n);
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */