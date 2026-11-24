class Solution {
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        bt(0, s, path, res);
        return res;
    }

    private void bt(int i, String s, List<String> path, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j ++) {
            // System.out.println(s.substring(i, j+1));
            if (isPalindrome(i, j, s)) {
                path.add(s.substring(i, j+1));
                bt(j+1, s, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
