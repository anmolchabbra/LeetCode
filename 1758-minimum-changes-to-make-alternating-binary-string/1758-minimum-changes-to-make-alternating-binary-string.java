class Solution {
    public int minOperations(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int start0 = 0, start1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') {
                    start0++;
                } else {
                    start1++;
                }
            } else {
                if (s.charAt(i) != '1') {
                    start0++;
                } else {
                    start1++;
                }
            }
            
        }
        return Math.min(start0, start1);
    }
}