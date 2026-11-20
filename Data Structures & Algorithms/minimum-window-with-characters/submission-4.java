class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] sCnt = new int[128];
        int[] tCnt = new int[128];
        int left = -1;
        int right = s.length();
        for (char c : t.toCharArray()) {
            tCnt[c] ++;
        }
        char[] sChar = s.toCharArray();
        int l = 0;
        for (int r = 0; r < sChar.length; r ++) {
            sCnt[sChar[r]] ++;
            while (isCover(sCnt, tCnt)) {
                if (right - left > r - l) {
                    right = r;
                    left = l;
                }
                sCnt[sChar[l]] --;
                l ++;
            }
        }
        return (right - left >= s.length()) ? "" : s.substring(left, right+1);
    }

    private boolean isCover(int[] sCnt, int[] tCnt) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
