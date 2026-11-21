class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList());
        int[] inDeg = new int[numCourses];
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] pre : prerequisites) {
            g[pre[1]].add(pre[0]);
            inDeg[pre[0]] ++; 
        }
        for (int i = 0; i < numCourses; i ++) {
            if (inDeg[i] == 0) {
                q.addLast(i);
            }
        }
        if (q.isEmpty()) {
            return false;
        }
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            visited[cur] = true;
            for (int nei : g[cur]) {
                inDeg[nei] --;
                if (inDeg[nei] == 0) {
                    q.addLast(nei);
                }
            }
        }
        for (int i = 0; i < numCourses; i ++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
