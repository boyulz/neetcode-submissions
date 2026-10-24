class Solution {
    // dp[i] = dp[i-1] + dp[i-2];
    // i-1: i != 0
    // i-2: 10 <= (i-1)*10 + i <= 26
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+2];
        dp[1] = 1;
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) != '0') {
                dp[i+2] += dp[i+1];
            }
            if (i >= 1) {
                int num = (s.charAt(i-1)-'0') * 10 + (s.charAt(i)-'0');
                if (num >= 10 && num <= 26) {
                    dp[i+2] += dp[i];
                }
            }
        }
        return dp[n+1];
    }
}
