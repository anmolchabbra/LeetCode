class Solution {
    public int getAllPossible(int stringLen) {
        //System.out.println(stringLen);
        int count = stringLen;
        for (int k = 2; k <= stringLen; k++) {
            int rem = stringLen - k;
            count += (rem + 1);
        }
        return count;
    }
    int mod = (int)1e9 + 7;
    public int countHomogenous(String s) {
        
        int count = 1;
        int i = 0, j = 1;
        int stringLen = 1;
        
        int[] map = new int[26];
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                stringLen++;
            } else {
                //System.out.println(stringLen);
                
                i = j;
                stringLen = 1;
            }
            j++;
            count = (count + stringLen) % mod;
        }
        
        return count ;
    }
}