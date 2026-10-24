class FileSystem {
    private class Node {
        String name;
        boolean isFile = false;
        Map<String, Node> children = new HashMap<>();
        StringBuilder content = new StringBuilder();
    }

    private Node root;

    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        Node cur = traverse(path);
        if (cur.isFile) {
            ans.add(cur.name);
        } else {
            ans.addAll(cur.children.keySet());
            Collections.sort(ans);
        }
        return ans;
    }
    
    public void mkdir(String path) {
        traverseAndCreate(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur = traverseAndCreate(filePath);
        cur.isFile = true;
        cur.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node cur = traverse(filePath);
        return cur.content.toString();
    }

    private Node traverse(String path) {
        Node cur = root;
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.isEmpty()) continue;
            cur = cur.children.get(part);
        }
        return cur;
    }

    private Node traverseAndCreate(String path) {
        Node cur = root;
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.isEmpty()) continue;
            if (!cur.children.containsKey(part)) {
                Node newNode = new Node();
                newNode.name = part;
                cur.children.put(part, newNode);
            }
            cur = cur.children.get(part);
        }
        return cur;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
