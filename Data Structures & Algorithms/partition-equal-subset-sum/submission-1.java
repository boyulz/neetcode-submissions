class Solution {
    // dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0)   return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= sum; j ++) {
                if (j >= nums[i]) {
                    dp[i+1][j] = dp[i][j] || dp[i][j-nums[i]];
                } else {
                    dp[i+1][j] = dp[i][j];
                }
            }
        }
        return dp[n][sum];
    }
}
