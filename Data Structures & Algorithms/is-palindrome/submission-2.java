class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int r = str.length() - 1;
        int l = 0;
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l ++;
            r --;
        }
        if (r > l) {
            return false;
        }
        return true;
    }
}
