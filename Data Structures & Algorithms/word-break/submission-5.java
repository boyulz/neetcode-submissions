class Solution {
    // dp[i] = dp[i-j]
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i ++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i-len, i).equals(word) && !dp[i]) {
                    dp[i] = dp[i-len];
                    if (dp[i]) {
                        continue;
                    }
                } 
            }
        }
        return dp[n];
    }
}