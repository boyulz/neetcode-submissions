class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> keyToNode = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) {
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            remove(node);
            moveToFront(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            remove(node);
            moveToFront(node);
        } else {
            Node node = new Node(key, value);
            if (keyToNode.size() == capacity) {
                Node remove = dummy.prev;
                keyToNode.remove(remove.key);
                remove(remove);
            }
            moveToFront(node);
            keyToNode.put(key, node);
        }
    }

    private void moveToFront(Node x) {
        dummy.next.prev = x;
        x.next = dummy.next;
        x.prev = dummy;
        dummy.next = x;
    }

    private void remove(Node x) {
        x.next.prev = x.prev;
        x.prev.next = x.next;
    }
}
