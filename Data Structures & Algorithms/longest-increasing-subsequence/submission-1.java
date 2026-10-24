class Solution {
    // dp[i] = (dp[上一个比nums[i]小的] / 0) + 1
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i ++) {
            int cnt = 0;
            for (int j = i-1; j >= 0; j --) {
                if (nums[j] < nums[i]) {
                    cnt = Math.max(dp[j], cnt);
                }
            }
            dp[i] = cnt + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
