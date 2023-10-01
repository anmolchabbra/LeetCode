class Solution {
    public boolean isPalindrome(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            char atLoc = s.charAt(i);
            if (Character.isLetter(atLoc) || Character.isDigit(atLoc)) {
                newString += Character.toLowerCase(atLoc);
            }
        }
        System.out.println(newString);
        int l = 0, r = newString.length() - 1;
        while (l < r) {
            if (newString.charAt(l) != newString.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}