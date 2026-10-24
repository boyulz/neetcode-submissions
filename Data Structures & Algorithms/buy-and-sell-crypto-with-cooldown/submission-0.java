class Solution {
    // dp(i, 0) = max(dp(i-1, 0), dp(i-1, 1) + prices[i]))
    // dp(i, 1) = max(dp(i-1, 1), dp(i-2, 0) - prices[i]))
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < 2; j ++) {
                if (j == 0) {
                    dp[i+2][0] = Math.max(dp[i+1][0], dp[i+1][1] + prices[i]);
                } else {
                    dp[i+2][1] = Math.max(dp[i+1][1], dp[i][0] - prices[i]);
                }
            }
        }
        return dp[n+1][0];
    }
}
