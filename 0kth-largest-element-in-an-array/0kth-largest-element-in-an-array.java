class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (pq.size() < k) {
                pq.offer(n);
            } else {
                pq.offer(n);
                pq.poll();
            }
        }
        return pq.poll();
    }
}