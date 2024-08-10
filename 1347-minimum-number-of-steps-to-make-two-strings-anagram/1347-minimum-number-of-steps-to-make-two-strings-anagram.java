class Solution {
    public int minSteps(String s, String t) {
        int[] first = new int[26];
        for (int i = 0; i < s.length(); i++) {
            first[s.charAt(i) - 'a']++;
            first[t.charAt(i) - 'a']--;
        }
        int steps = 0;
        for (int i = 0; i < 26; i++) {
           // steps += Math.max(0, first[i]);
           if (first[i] > 0) {
               steps+= first[i];
           }
        }
        return steps;
    }
}