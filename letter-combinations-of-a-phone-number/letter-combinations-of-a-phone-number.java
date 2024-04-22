class Solution {
    String[] set = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return new ArrayList<String>();
        }
    
        List<String> ans = new ArrayList<>();
        makeComb(digits, 0, "", ans);
        return ans;
    }
    
    private void makeComb(String digits, int pos, String current, List<String> ans) {
        if (pos >= digits.length()) {
            ans.add(current);
            current = "";
            return;
        }
        
        String a = set[digits.charAt(pos) - '0'];
        
        for (int i = 0; i < a.length(); i++) {
            makeComb(digits, pos + 1, current + a.charAt(i), ans);
        }
    }
}