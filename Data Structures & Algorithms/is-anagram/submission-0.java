class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            cnt[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            if (cnt[c - 'a'] == 0) {
                return false;
            }
            cnt[c - 'a'] --;
        }
        return true;
    }
}
