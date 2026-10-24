class Solution {
    // dp[i] = 
    public String longestPalindrome(String s) {
        int n = s.length();

        int start = 0;
        int end = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[n][n];
        for (int r = 0; r < n; r ++) {
            for (int l = r-1; l >= 0; l --) {
                if (s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[r-1][l+1])) {
                    dp[r][l] = true;
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
