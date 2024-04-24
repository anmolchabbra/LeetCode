class Solution {
    
    ArrayList<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        traverse(n, "", 0, 0);
        return ans;
    }

    public void traverse(int n, String curr_string, int opening_count, int closing_count) {

        if(closing_count > opening_count || closing_count > n || opening_count > n) {
            return;
        }

        if(opening_count == n && closing_count == n) {
            ans.add(curr_string);
            return;
        }

        traverse(n, curr_string + "(", opening_count + 1, closing_count);
        traverse(n, curr_string + ")", opening_count, closing_count + 1);
        
    }

}