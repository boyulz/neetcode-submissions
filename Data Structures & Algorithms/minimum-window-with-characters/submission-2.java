class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c] ++;
        }
        int resLeft = 0;
        int resRight = 0;
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int[] window = new int[128];
        for (int r = 0; r < m; r ++) {
            window[s.charAt(r)] ++; 
            if (r - l + 1 < n) {
                continue;
            }
            while (isCovered(cnt, window)) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    resRight = r;
                    resLeft = l;
                }
                window[s.charAt(l)] --;
                l ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }

    private boolean isCovered(int[] cnt, int[] window) {
        for (int i = 'a'; i <= 'z'; i ++) {
            if (cnt[i] > window[i]) {
                return false;
            }
        }

        for (int i = 'A'; i <= 'Z'; i ++) {
            if (cnt[i] > window[i]) {
                return false;
            }
        }

        return true;
    }
}
