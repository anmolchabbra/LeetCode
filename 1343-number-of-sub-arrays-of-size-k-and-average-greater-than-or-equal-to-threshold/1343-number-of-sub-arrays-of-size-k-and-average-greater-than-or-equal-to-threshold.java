class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0;
        int j = k;
        int count = 0;
        int avg = 0;
        for (int t = 0; t < k; t++) {
            avg += arr[t];
        }
        int temp = avg;
        avg /= k;
        if (avg >= threshold) {
            count++;
        }
        avg = temp;
        while (j < arr.length) {
            
            int newAvg = avg - (arr[i++]) + arr[j++];
            avg = newAvg;
            newAvg /= k;
            if (newAvg >= threshold) {
                ++count;
            }
        }
        return count;
    }
}