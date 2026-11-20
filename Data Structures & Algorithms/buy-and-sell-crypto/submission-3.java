class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minBuy = prices[0];
        for (int p : prices) {
            max = Math.max(p - minBuy, max);
            minBuy = Math.min(minBuy, p);
        }
        return max;
    }
}
