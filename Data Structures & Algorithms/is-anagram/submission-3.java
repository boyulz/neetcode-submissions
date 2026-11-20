class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        char[] sChar = new char[26];
        char[] tChar = new char[26];
        for(int i = 0; i < len; i ++) {
            sChar[s.charAt(i)-'a'] ++;
            tChar[t.charAt(i)-'a'] ++;
        }
        if (Arrays.equals(sChar, tChar)) {
            return true;
        } else {
            return false;
        }
    }
}
