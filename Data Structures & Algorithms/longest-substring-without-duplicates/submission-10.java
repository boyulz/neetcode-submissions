class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        int[] cnt = new int[128];
        int l = 0;
        for (int r = 0; r < len; r ++) {
            if (cnt[s.charAt(r)] > 0) {
                while (cnt[s.charAt(r)] > 0) {
                    cnt[s.charAt(l)] --;
                    l ++;
                }
            }
            cnt[s.charAt(r)] ++;
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
