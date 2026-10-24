class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int p : prices) {
            max = Math.max(max, p - minPrice);
            minPrice = Math.min(p, minPrice);
        }
        return max;
    }
}
