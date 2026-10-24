class Solution {
    // dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = 0; i < n; i ++) {
            dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i]);
        }
        return dp[n+1];
    }
}

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] f = new int[n + 2];
//         for (int i = 0; i < n; i++) {
//             f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
//         }
//         return f[n + 1];
//     }
// }


