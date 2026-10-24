class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        int n = prices.length;
        if (n == 0) {
            return ans;
        }
        for (int i = 0; i < n; i ++) {
            ans = Math.max(prices[i] - min, ans);
            min = Math.min(prices[i], min);
        }
        return ans;
    }
}
