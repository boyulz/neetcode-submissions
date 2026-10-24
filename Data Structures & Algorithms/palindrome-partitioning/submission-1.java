class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        bt(s, 0, path, ans);
        return ans;
    }

    private void bt(String s, int idx, List<String> path, List<List<String>> ans) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i ++) {
            if (isPalin(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                bt(s, i+1, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalin(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
