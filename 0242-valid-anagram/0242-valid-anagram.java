class Solution {
    public boolean isAnagram(String s, String t) {
        int[] firstCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            firstCount[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (firstCount[index] > 0) {
                firstCount[index] -= 1;
            } else {
                 firstCount[index] += 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            //System.out.println(firstCount[i]);
            if (firstCount[i] != 0) {
                return false;
            }
        }
        return true;
    }
}