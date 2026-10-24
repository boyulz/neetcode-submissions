class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] cnt = new int[128];
        int l = 0;
        for (int r = 0; r < s.length(); r ++) {
            cnt[s.charAt(r)] ++;
            while (cnt[s.charAt(r)] > 1) {
                cnt[s.charAt(l)] --;
                l ++;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
