class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] cnt = new int[26];
        int maxFreq = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r ++) {
            cnt[s.charAt(r) - 'A'] ++;
            maxFreq = Math.max(cnt[s.charAt(r) - 'A'], maxFreq);
            while (r - l + 1 - maxFreq > k) {
                cnt[s.charAt(l) - 'A'] --;
                l ++;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
