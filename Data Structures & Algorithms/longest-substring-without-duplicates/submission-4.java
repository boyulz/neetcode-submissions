class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int n = s.length();
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r ++) {
            cnt[s.charAt(r)] ++;
            while (cnt[s.charAt(r)] > 1) {
                cnt[s.charAt(l)] --;
                l ++;
            }
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }
}
