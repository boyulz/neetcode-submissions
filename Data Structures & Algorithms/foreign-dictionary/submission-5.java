class Solution {
    public String foreignDictionary(String[] words) {
        List<List<Character>> g = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            g.add(new ArrayList<>());
        }
        int[] inDeg = new int[26];
        Set<Character> set = new HashSet<>();
        StringBuilder st = new StringBuilder();

        // 改动 1：先收集所有出现过的字母
        for (String w : words) {
            for (int j = 0; j < w.length(); j++) {
                set.add(w.charAt(j));
            }
        }

        // 比较相邻单词，建图
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            int diffPos = findDiffPos(prev, cur);
            if (diffPos == -1) {
                // 改动 2：前缀相同但前一个词更长，顺序不合法
                if (prev.length() > cur.length()) {
                    return "";
                }
            } else {
                char from = prev.charAt(diffPos);
                char to = cur.charAt(diffPos);
                g.get(from - 'a').add(to);
                inDeg[to - 'a']++;
            }
        }

        // 拓扑排序，先放入所有入度为 0 的字母
        Deque<Character> q = new ArrayDeque<>();
        for (char c : set) {
            if (inDeg[c - 'a'] == 0) {
                q.addLast(c);
                st.append(c);
            }
        }
        while (!q.isEmpty()) {
            char cur = q.pollFirst();
            for (char ch : g.get(cur - 'a')) {
                inDeg[ch - 'a']--;
                // 改动 3：入度减到 0 才入队
                if (inDeg[ch - 'a'] == 0) {
                    q.addLast(ch);
                    st.append(ch);
                }
            }
        }

        // 改动 4：有环时会有字母没被输出
        if (st.length() < set.size()) {
            return "";
        }
        return st.toString();
    }

    // 返回两个单词第一个不同字母的位置，没有就返回 -1
    private int findDiffPos(String a, String b) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}