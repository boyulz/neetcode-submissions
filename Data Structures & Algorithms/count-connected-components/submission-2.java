class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e: edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                res += 1;
                q.addLast(i);
                bfs(g, q, visited);
            }
        }
        return res;
    }

    private void bfs(List<Integer>[] g, Deque<Integer> q, boolean[] visited) {
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            visited[cur] = true;
            for (int nei : g[cur]) {
                if (!visited[nei]) {
                    q.addLast(nei);
                }
            }
        }
    }
}
