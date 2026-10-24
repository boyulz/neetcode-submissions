class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxCount = 0;
        int n = s.length();
        int[] cnt = new int[26];
        int l = 0;
        for (int r = 0; r < n; r ++) {
            cnt[s.charAt(r) - 'A'] ++;
            maxCount = Math.max(maxCount, cnt[s.charAt(r) - 'A']);
            while (r - l + 1 - maxCount > k) {
                cnt[s.charAt(l) - 'A'] --;
                l ++;
            }
            max = Math.max(r-l+1, max);
        }
        return max;
    }
}
