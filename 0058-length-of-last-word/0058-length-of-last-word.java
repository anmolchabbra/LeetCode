class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int count = 0;
        boolean isWordStarted = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' ) {
                isWordStarted = true;
                count++;
            }
            if (isWordStarted && s.charAt(i) == ' ') {
                break;
            }
        }
        return count;
    }
}