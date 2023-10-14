class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length;) {
            if (intervals[i][0] < end) {
                ++count;
                end = Math.min(end, intervals[i][1]);
                i++;
                
            } else {
                end = intervals[i][1];
                i++;
            }
        }
        return count;
    }
}