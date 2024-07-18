class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        
        int halfReverted = 0;
        while (x > halfReverted) {
            halfReverted = halfReverted * 10 + (x % 10);
            x /= 10;
        }
        
        return (x == halfReverted || x == halfReverted / 10);
    }
}