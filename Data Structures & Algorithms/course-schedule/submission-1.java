class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] inDeg = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        for (int[] pre : prerequisites) {
            g[pre[1]].add(pre[0]);
            inDeg[pre[0]] ++;
        }
        for (int i = 0; i < numCourses; i ++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i ++) {
                int course = q.poll();
                for (int neighboor : g[course]) {
                    inDeg[neighboor] --;
                    if (inDeg[neighboor] == 0) {
                        q.offer(neighboor);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i ++) {
            if (inDeg[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
