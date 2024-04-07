class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int profit = 0;
        int currPurchase = prices[0];
        while (l < prices.length) {
            if (currPurchase <= prices[l]) {
                profit += (prices[l] - currPurchase);
                currPurchase = prices[l];
            } else {
               currPurchase = prices[l];
            }
            l++;
        }
        return profit;
    }
}