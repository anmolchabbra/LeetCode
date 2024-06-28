class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int winSize = s1.length();
        
        int[] first = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            first[s1.charAt(i) - 'a'] += 1;
        }
        
        int j = 0;
        int i = 0;
        
        int[] second = new int[26];
        
        while (j < s2.length()) {
            second[s2.charAt(j) - 'a'] += 1;
            if (j - i + 1 >= winSize) {
                boolean isPerm = true;
                for (int k = 0; k < 26; k++) {
                    if (first[k] != second[k]) {
                        isPerm = false;
                        break;
                    }
                }
                if (isPerm) return true;
                second[s2.charAt(i) - 'a'] -= 1;
                i++;   
            }
            j++;
        }
        return false;
    }
}