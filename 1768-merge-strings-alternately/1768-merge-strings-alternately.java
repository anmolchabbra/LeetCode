class Solution {
    public String mergeAlternately(String first, String second) {
        String result = "";
        int index = 0, i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (index % 2 == 0) {
                result += first.charAt(i);
                i++;
            } else {
                result += second.charAt(j);
                j++;
            }
            index++;
        }
        while (i < first.length()) {
            result += first.charAt(i);
            i++;
        }
        while (j < second.length()) {
            result += second.charAt(j);
            j++;
        }
        return result;
    }
}