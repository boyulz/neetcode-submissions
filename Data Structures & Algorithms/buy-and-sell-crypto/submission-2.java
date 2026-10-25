class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int p : prices) {
            max = Math.max(p - minPrice, max);
            minPrice = Math.min(minPrice, p);
        }
        return max;
    }
}
