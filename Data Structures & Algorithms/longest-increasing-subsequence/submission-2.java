class Solution {
   // dp[i] = max(dp[j] from i-1 to 0 && nums[i] > nums[j]) + 1
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) {
            int val = 0;
            for (int j = i-1; j >= 0; j --) {
                if (nums[i] > nums[j]) {
                    val = Math.max(val, dp[j]);
                }
            }
            dp[i] = val + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
