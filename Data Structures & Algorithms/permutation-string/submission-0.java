class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Cnt = new int[26];
        for (int i = 0; i < s1.length(); i ++) {
            s1Cnt[s1.charAt(i) - 'a'] ++;
        }
        int[] s2Cnt = new int[26];
        int l = 0;
        for (int r = 0; r < s2.length(); r ++) {
            s2Cnt[s2.charAt(r) - 'a'] ++;
            while (isCovered(s1Cnt, s2Cnt)) {
                if (Arrays.equals(s1Cnt, s2Cnt)) {
                    return true;
                }
                s2Cnt[s2.charAt(l) - 'a'] --;
                l ++;
            }
        }
        return false;
    }

    private boolean isCovered(int[] s1Cnt, int[] s2Cnt) {
        for (int i = 0; i < 26; i ++) {
            if (s1Cnt[i] > s2Cnt[i]) {
                return false;
            }
        }
        return true;
    }
}
