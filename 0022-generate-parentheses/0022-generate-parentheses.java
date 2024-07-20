class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        balance(n, 0, 0, "", ans);
        return ans;
    }
    
    public void balance(int n, int c, int o, String toAdd, List<String> ans) {
        if (toAdd.length() >= n * 2) {
            ans.add(toAdd);
            toAdd = "";
        }
        if (o < n) {
            balance(n, c , o + 1, toAdd+ "(", ans);
        }
        if (c < o) {
            balance(n, c + 1, o, toAdd + ")", ans);
        }
    }
}