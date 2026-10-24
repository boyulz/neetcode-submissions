class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int r = 0; r < n; r ++) {
            for (int l = 0; l <= r; l ++) {
                // System.out.println(l);
                // System.out.println(r);
                if (s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    ans ++;
                }
            }
        }
        return ans;
    }
}
