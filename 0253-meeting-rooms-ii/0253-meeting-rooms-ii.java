class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Arrays.sort(intervals, (a ,b) -> Integer.compare(a[0], b[0]));
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int endLast = intervals[0][1];
        // pq.add(endLast);
        // int minRoom = 1;
        // for (int i = 1; i < intervals.length; i++) {
        //     if (intervals[i][0] < pq.peek()) {
        //         minRoom++;
        //         pq.add(intervals[i][1]);
        //         continue;
        //     }
        //     pq.poll();
        //     pq.add(intervals[i][1]);
        // }
        // return minRoom;
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.add(intervals[0][1]);
        
    for (int i = 1; i < intervals.length; i++) {
        if (!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek() ) {
          minHeap.poll(); 
            
        }    
        
        minHeap.add(intervals[i][1]);
    
    }
        
        
    return minHeap.size();
        
    }
}