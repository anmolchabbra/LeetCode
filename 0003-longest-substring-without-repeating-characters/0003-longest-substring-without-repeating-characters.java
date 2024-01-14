class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int max = 0;
        
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                while (i <= j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        i++;
                        //map.put(s.charAt(j), 1);
                        break;
                    }
                    map.remove(s.charAt(i));
                    i++;
                }
            } else {
                map.put(s.charAt(j), 1);
                max = Math.max(max, j - i + 1);
            }
            j++;
        }
        return max;
    }
}