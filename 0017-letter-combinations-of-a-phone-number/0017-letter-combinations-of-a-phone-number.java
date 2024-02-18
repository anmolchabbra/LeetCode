class Solution {
    public List<String> letterCombinations(String digits) {
    
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> ans = new ArrayList<>();
        
        if (digits.length() == 0) {
            return ans;
        }
        
        helper(map, ans, 0, "", digits);
        
        return ans;
    }
    
    public void helper(String[] map, List<String> ans, int index, String curr, String digits) {
        if (index >= digits.length()) {
            ans.add(curr);
            curr = "";
            return;
        }
        
        Character c = digits.charAt(index);
        int charValue = Integer.valueOf(""+c);
        //System.out.println("Charvalie" + charValue);
        String combination = map[charValue];
       // System.out.println("Comb" + combination);
        for (int j = 0; j < combination.length(); j++) {
            curr = curr + combination.charAt(j);
            helper(map, ans, index + 1, curr, digits);
            curr = curr.substring(0, curr.length() - 1);//////'//'+ combination.charAt(j);
        }
    }
}