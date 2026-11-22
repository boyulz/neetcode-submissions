class Solution {
    // dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(f(Arrays.copyOfRange(nums, 1, n)), f(Arrays.copyOfRange(nums, 2, n-1)) + nums[0]);
    }

    private int f(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }
        return dp[n - 1];
    }
}
