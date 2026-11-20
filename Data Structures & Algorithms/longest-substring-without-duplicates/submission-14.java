class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int[] ch = new int[128];
        int res = 0;
        for (int r = 0; r < s.length(); r ++) {
            ch[s.charAt(r)] ++;
            while (ch[s.charAt(r)] > 1) {
                ch[s.charAt(l)] --;
                l ++;
            }
            res = Math.max(r-l+1, res);
        }
        return res;
    }
}
