class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        generatePrem(s, 0, "", ans);
        return ans;
    }
    
    
    public void generatePrem(String s, int start, String curr, List<String> ans) {
        if (start == s.length()) {
            ans.add(curr);
            curr = "";
            return;
        }
        char charAtStart = s.charAt(start);
        
        if (!Character.isDigit(charAtStart)) {
            if (Character.isUpperCase(charAtStart)) {
                char upperCaseChar = Character.toLowerCase(charAtStart);
                generatePrem(s, start + 1, curr + upperCaseChar, ans);
            } else {
                char lowerCaseChar = Character.toUpperCase(charAtStart);
                generatePrem(s, start + 1, curr + lowerCaseChar, ans);
            }
        }
        
        generatePrem(s, start + 1, curr + charAtStart, ans);
    }
}