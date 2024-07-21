class Solution {
    //Appriach: Expanding from center
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //For odd length palindromes
            res += count(s, i, i);
            //For even length
            res += count(s, i, i + 1);
        }
        return res;
    }
    private int count(String s, int l, int r) {
        int ans = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            ans++;
        }
        return ans;
    }
}