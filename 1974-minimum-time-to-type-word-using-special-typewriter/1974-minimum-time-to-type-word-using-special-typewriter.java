class Solution {
    public int minTimeToType(String word) {
        char onWheel = 'a';
        int time = 0;
        int n = 0;
        while (n != word.length()) {
            char curr = word.charAt(n);
            if (curr == onWheel) {
                time++;
                n++;
            } else {
                int far = (int)(curr - onWheel);
                far = Math.abs(far);
                int clockWise = far;
                int antiClockWise = (26 - far);
                int timeToAdd = Math.min(clockWise, antiClockWise);
                time += timeToAdd;
                onWheel = curr;
            }
        }
        return time;
    }
}