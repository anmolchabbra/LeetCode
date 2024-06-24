class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals
        int minOverlap = 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int last = Integer.MIN_VALUE;
        
        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            
            if (currStart >= last) {
                last = currEnd;
            } else {
                minOverlap++;
            }
        }
        
        return minOverlap;
        
    }
}