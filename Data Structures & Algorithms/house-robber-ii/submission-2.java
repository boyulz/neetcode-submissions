class Solution {
    // dp[i] = Math.max(dp[i-1], dp[i-2] + houses[i]);
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(f(Arrays.copyOfRange(nums, 1, n)), f(Arrays.copyOfRange(nums, 2, n-1)) + nums[0]);
    }

    private int f(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = 0; i < n; i ++) {
            dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i]);
        }
        return dp[n+1];
    }
}
