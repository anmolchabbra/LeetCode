class Solution {
    public boolean isPalindrome(int x) {
        String input = Integer.toString(x);
        int l = 0, r = input.length() - 1;
        while (l <= r) {
            if (input.charAt(l) != input.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}