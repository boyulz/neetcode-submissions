class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] path = new char[n*2];
        bt(n, 0, 0, path);
        return res;
    }

    private void bt(int n, int l, int r, char[] path) {
        if (l + r == n*2) {
            res.add(new String(path));
            return;
        }
        if (l != 0 && l > r) {
            if (l < n) {
                path[l+r] = '(';
                bt(n, l+1, r, path);
            }
            if (r < n) {
                path[l+r] = ')';
                bt(n, l, r+1, path);
            }
        } else {
            if (l < n) {
                path[l+r] = '(';
                bt(n, l+1, r, path);
            }
        }
    }
}
