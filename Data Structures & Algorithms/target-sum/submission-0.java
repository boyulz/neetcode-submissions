class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // p
        // s-p
        // p - (s-p) = t
        // p = (s + t) / 2
        target += Arrays.stream(nums).sum();
        if (target < 0 || target % 2 != 0) {
            return 0;
        }
        target /= 2;
        // dp(i, t) = dp(i - 1, t) + dp(i - 1, t - nums[i]);
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i < nums.length; i ++) {
            for (int t = 0; t <= target; t ++) {
                if (t < nums[i]) {
                    dp[i + 1][t] = dp[i][t];
                } else {
                    dp[i + 1][t] = dp[i][t] + dp[i][t - nums[i]];
                }
            }
        }
        return dp[nums.length][target];
    }
}