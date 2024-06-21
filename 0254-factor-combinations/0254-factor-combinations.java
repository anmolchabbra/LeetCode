class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(n, new ArrayList<Integer>(), ans, 2);
        
        return ans;
    
    }
    
    private void helper(int n, List<Integer> toPut, List<List<Integer>> ans, int index) {
        if (n == 1 ) {
            if (toPut.size() > 1)
                ans.add(new ArrayList<>(toPut));
        }
        for (int i = index; i <= n; i++) {
            if (n % i == 0) {
                toPut.add(i);
                helper(n/i, toPut, ans, i);
                toPut.remove(toPut.size() - 1);
            }
        }
        
    }
    
}