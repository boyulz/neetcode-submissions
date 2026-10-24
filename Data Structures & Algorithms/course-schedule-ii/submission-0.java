class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        int[] inDeg = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[numCourses];
        List<Integer> ans = new ArrayList<>();
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
        if (q.isEmpty())    return new int[]{};
        while (!q.isEmpty()) {
            int course = q.poll();
            ans.add(course);
            vis[course] = true;
            for (int p : g[course]) {
                inDeg[p] --;
                if (inDeg[p] == 0 && !vis[p]) {
                    q.offer(p);
                }
            }
        }
        if (ans.size() < numCourses)   return new int[]{};
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
