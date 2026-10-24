class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        int[] inDeg = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
            inDeg[p[0]] ++;
        }
        for (int i = 0; i < numCourses; i ++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        if (q.isEmpty())    return false;
        while (!q.isEmpty()) {
            int course = q.poll();
            vis[course] = true;
            for (int p : g[course]) {
                inDeg[p] --;
                if (inDeg[p] == 0 && !vis[p]) {
                    q.offer(p);
                }
            }
        }
        for(int i = 0; i < numCourses; i ++) {
            if (!vis[i]){
                return false;
            }
        }
        return true;
    }
}
