class Solution {
    // dp[i] = dp[i-1] + dp[i-2]
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        dp[1] = 1;
        for(int i = 0; i < n; i ++) {
            dp[i+2] = dp[i+1] + dp[i];
        }
        return dp[n+1];
    }
}
