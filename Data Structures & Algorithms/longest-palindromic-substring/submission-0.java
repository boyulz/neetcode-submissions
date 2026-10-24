class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0, maxLen = 1;
        for (int r = 0; r < n; r ++) {
            for (int l = 0; l < r; l ++) {
                if (s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        start = l;
                        end = r;
                        maxLen = r-l+1;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
