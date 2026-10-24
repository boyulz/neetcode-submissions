class Solution {
    // dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1])
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = 0; i < n; i ++) {
            dp[i+2] = Math.max(dp[i] + nums[i], dp[i+1]);
        }
        return dp[n+1];
    }
}



