class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0, j = 0, totalTime = 0;
        while (i < neededTime.length) {
            int currTotal = 0, currMax = 0;
            
            //Finding same color ballon as of i th ones
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }
            
            //Now we are at the end of one group lets delete keep only
            //Largest time taking one, so
            totalTime += currTotal - currMax;
            
            i = j;
            
        }
        return totalTime;
    }
}