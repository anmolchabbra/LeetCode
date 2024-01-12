class Solution {
    public boolean isPalindrome(String s) {
        String preProcess = "";
        for (Character c : s.toCharArray()) {
            
            char curr = Character.toLowerCase(c);
            
            if ((curr >= 'a' && curr <= 'z') || (curr >= '0' && curr <= '9')) {
                preProcess += curr;
            }
        }
        
        System.out.print(preProcess);
        
        int l = 0, r = preProcess.length() - 1;
        while (l < r) {
            if (preProcess.charAt(l) != preProcess.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}