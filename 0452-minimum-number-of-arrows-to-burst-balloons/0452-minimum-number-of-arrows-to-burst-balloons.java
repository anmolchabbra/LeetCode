class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int minArrows = 0;
        int start  = points[0][0], end = points[0][1];
        int size = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                start = Math.min(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            } else {
                start= points[i][0];
                end = points[i][1];
                size++;
            }
        }
        return size;
    }
}