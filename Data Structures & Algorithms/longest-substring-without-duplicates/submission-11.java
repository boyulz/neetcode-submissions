class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        int[] cnt = new int[128];
        int l = 0;
        for (int r = 0; r < len; r ++) {
            cnt[s.charAt(r)] ++;
            while (cnt[s.charAt(r)] > 1) {
                cnt[s.charAt(l)] --;
                l ++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
