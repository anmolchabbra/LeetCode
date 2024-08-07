class Solution {
     private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int last = n % 10;
            sum += (last * last);
            n = n / 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
       Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n==1;
    }
}