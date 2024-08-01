class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //sort by start time
        Arrays.sort(intervals, (a ,b) -> Integer.compare(a[0], b[0]));
        if (intervals.length == 0) return true;
        int endLast = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < endLast) return false;
            endLast = intervals[i][1];
        }
        return true;
    }
}