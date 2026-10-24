class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a'] ++;
        }
        int[] window = new int[26];
        int l = 0;
        int r = 0;
        while (r < n) {
            window[s2.charAt(r) - 'a'] ++;
            if (r - l + 1 < m) {
                r ++;
                continue;
            }
            // System.out.println(r);
            if (Arrays.equals(cnt, window)) {
                return true;
            }
            window[s2.charAt(l) - 'a'] --;
            l ++;
            r ++;
        }
        return false;
    }
}
