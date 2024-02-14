class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            if (first != second) pq.add(first - second);
        }
        
        return pq.size() == 0 ? 0 : pq.poll();
    }
}