class Solution {
    // dp[i][j] - From i to j if is a palin
    // dp[i][j] = dp[i+1][j-1];
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int r = 0; r < n; r ++) {
            for (int l = r; l >= 0; l --) {
                if (s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[r-1][l+1])) {
                    dp[r][l] = true;
                    ans ++;
                }
            }
        }
        return ans;
    }
}
