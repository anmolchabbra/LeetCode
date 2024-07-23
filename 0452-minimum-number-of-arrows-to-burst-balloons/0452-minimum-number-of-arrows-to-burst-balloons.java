class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int minArrows = 0;
        int start  = points[0][0], end = points[0][1];
        List<int[]> col = new ArrayList<>();
        col.add(new int[]{start, end});
        for (int i = 1; i < points.length; i++) {
            int[] p = col.get(col.size() - 1);
            if (points[i][0] <= p[1]) {
                start = Math.min(p[0], points[i][0]);
                end = Math.min(p[1], points[i][1]);
                col.remove(col.size() - 1);
                col.add(new int[] {start, end});
            } else {
                col.add(points[i]);
            }
        }
        return col.size();
    }
}