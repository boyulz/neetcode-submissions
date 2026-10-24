class Solution {
    // dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j == 0)   continue;
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[m][n];
    }
}
