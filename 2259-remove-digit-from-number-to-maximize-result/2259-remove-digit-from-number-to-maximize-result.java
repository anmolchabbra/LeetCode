class Solution {
    public String removeDigit(String number, char digit) {
        int max = 0;
        String ans = "";
        int n = number.length();
        List<Integer> occur = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                occur.add(i);
            }
        }
        for (Integer i : occur) {
            String possibleAns = number.substring(0, i) + number.substring(i + 1, n);
            if (ans.compareTo(possibleAns) < 0) {
                ans = possibleAns;
            }
        }
        return ans;
    }
}