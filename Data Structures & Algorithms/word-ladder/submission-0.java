class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i ++) {
                String str = q.poll();
                for (int j = 0; j < wordList.size(); j ++) {
                    if (visited[j]) {
                        continue;
                    }
                    String word = wordList.get(j);
                    if (canConvert(str, word)) {
                        if (word.equals(endWord)) {
                            return ans + 1;
                        }
                        visited[j] = true;
                        q.offer(word);
                    }
                }
            }
            ans ++;
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count ++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
