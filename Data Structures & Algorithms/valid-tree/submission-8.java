class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.addLast(new int[]{0, -1});
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int node = cur[0];
            int parent = cur[1];
            visited[node] = true;
            for (int nei : g[node]) {
                if (visited[nei] && nei != parent) {
                    return false;
                }
                if (!visited[nei]) {
                    q.addLast(new int[]{nei, node});
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

}
