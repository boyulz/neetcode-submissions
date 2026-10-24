class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i ++) {
            if (!vis[i]) {
                ans ++;
                dfs(i, -1, g, vis);
            }
        }
        return ans;
    }

    private void dfs(int node, int pre, List<Integer>[] g, boolean[] vis) {
        vis[node] = true;
        for (int n : g[node]) {
            if (n == node) continue;
            if (vis[n]) continue;
            dfs(n, node, g, vis);
        }
    }
}
