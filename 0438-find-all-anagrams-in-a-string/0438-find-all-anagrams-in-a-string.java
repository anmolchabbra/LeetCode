class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int charCount = 0;
        
        int[] checker = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            checker[p.charAt(i) - 'a'] += 1;
        }
        
        int[] sChecker = new int[26];
        
        int i = 0, j = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        while (j < s.length()) {
            
            Character curr = s.charAt(j);
            
        
            
            if (checker[curr - 'a'] > 0) {
                charCount++;
                sChecker[curr - 'a'] += 1;
                
                if (charCount == p.length()) {
                    boolean toAdd = true;
                    System.out.println(i);
                    for (int k = 0; k < 26; k++) {
                        
                        if (checker[k] != sChecker[k]) {
                            System.out.println("Gone Wrong" + i + " " + "chek" + checker[k] + "schecker" + sChecker[k] + " " +  k);
                            toAdd = false;
                            break;
                        }
                    }
                    if (toAdd)  {
                        ans.add(i);
                    }
                    sChecker[s.charAt(i) - 'a'] -= 1;
                    charCount--;
                    i++;
                }
            } else {
                for (int k = i; k <= j; k++) {
                    if (sChecker[s.charAt(k) - 'a'] > 0) sChecker[s.charAt(k) - 'a']-- ;
                    if (checker[s.charAt(k) - 'a'] > 0)
                        charCount--;
                }
                i=j;
                i++;
            }
            
            j++;
        }
    
        return ans;

    }
}


// class Solution {
//   public List<Integer> findAnagrams(String s, String p) {
//     int ns = s.length(), np = p.length();
//     if (ns < np) return new ArrayList();

//     int [] pCount = new int[26];
//     int [] sCount = new int[26];
//     // build reference array using string p
//     for (char ch : p.toCharArray()) {
//       pCount[(int)(ch - 'a')]++;
//     }

//     List<Integer> output = new ArrayList();
//     // sliding window on the string s
//     for (int i = 0; i < ns; ++i) {
//       // add one more letter 
//       // on the right side of the window
//       sCount[(int)(s.charAt(i) - 'a')]++;
//       // remove one letter 
//       // from the left side of the window
//       if (i >= np) {
//         sCount[(int)(s.charAt(i - np) - 'a')]--;
//       }
//       // compare array in the sliding window
//       // with the reference array
//       if (Arrays.equals(pCount, sCount)) {
//         output.add(i - np + 1);
//       }
//     }
//     return output;
//   }
// }