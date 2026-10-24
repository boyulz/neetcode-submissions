class Solution {
    public String minWindow(String s, String t) {
        int[] sCnt = new int[128];
        int[] tCnt = new int[128];
        for (char c : t.toCharArray()) {
            tCnt[c] ++;
        }
        int l = 0;
        int left = -1;
        int right = s.length();
        for (int r = 0; r < s.length(); r ++) {
            sCnt[s.charAt(r)] ++;
            while (isCover(sCnt, tCnt)) {
                if (r - l < right - left) {
                    right = r;
                    left = l;
                }
                sCnt[s.charAt(l)] --;
                l ++;
            }
        }
        return (right - left >= s.length()) ? "" : s.substring(left, right+1);
    }

    private boolean isCover(int[] sCnt, int[] tCnt) {
        for (int i = 'A'; i <= 'Z'; i ++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }

        for (int i = 'a'; i <= 'z'; i ++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }

        return true;
    }
}
