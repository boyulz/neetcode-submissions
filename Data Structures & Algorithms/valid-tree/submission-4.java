class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        
        if (!dfs(0, -1, g, vis)) return false;
        
        for (boolean v : vis) {
            if (!v) return false;
        }
        
        return true;
    }

    private boolean dfs(int i, int prev, List<Integer>[] g, boolean[] vis) {
        vis[i] = true;
        
        for (int node : g[i]) {
            if (node == prev) continue;
            if (vis[node]) return false;
            if (!dfs(node, i, g, vis)) return false;
        }
        
        return true;
    }
}