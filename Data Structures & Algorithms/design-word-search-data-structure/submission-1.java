class WordDictionary {
    private class Node {
        Node[] son = new Node[26];
        boolean end = false;
    }
    Node root = new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                Node newNode = new Node();
                cur.son[c] = newNode;
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, Node node) {
        Node cur = node;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node n : cur.son) {
                    if (n != null && dfs(word.substring(i+1, word.length()), n)) {
                        return true;
                    }
                }
                return false;
            } else {
                c -= 'a';
                if (cur.son[c] == null) {
                    return false;
                } else {
                    cur = cur.son[c];
                }
            }
        }
        return cur.end;
    }
}
