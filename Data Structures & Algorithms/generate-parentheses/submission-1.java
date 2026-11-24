class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] path = new char[n*2];
        bt(n, 0, 0, path, res);
        return res;
    }

    private void bt(int n, int left, int right, char[] path, List<String> res) {
        int idx = left + right;
        if (idx == 2*n) {
            res.add(new String(path));
            return;
        }

        if (left < n && (idx == 0 || left >= right)) {
            path[idx] = '(';
            bt(n, left+1, right, path, res);
        }

        if (right < n && left > right) {
            path[idx] = ')';
            bt(n, left, right+1, path, res);
        }
    }
}
