class Solution {
    public int minMeetingRooms(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
       
//         int[] prev = intervals[0];
//         int[] rooms = new int[intervals.length];
//         int curr = 0;
//         int room = 1;
//         rooms[0] = intervals[0][1];
//         for (int i = 1; i < intervals.length; i++) {
//              prev = intervals[i - 1];
//             int start = intervals[i][0];
//             int end = intervals[i][1];
//             if (start < prev[1]) {
//                 for (int j = 0 ; j <= curr; j++) {
//                     if (start >= rooms[j] ) {
//                         break;
//                     }
//                 }
//                 rooms[++curr] = end;
//                 for(int k = 0; k <= curr; k++) {
//                     System.out.println (rooms[k]);
//                 }
//                 room++;
//             }
//         }
//         return room;
        
        //Using Number Line approach
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int meetingRooms = 0;
        
        for (int iStart = 0, iEnd = 0; iStart < intervals.length; iStart++) {
            if (start[iStart] < end[iEnd]) meetingRooms++;
            else iEnd++;
        }
        
        return meetingRooms;
    }
}