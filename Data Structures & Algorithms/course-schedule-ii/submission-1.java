class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] inDeg = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();
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
                order.add(course);
                for (int neighboor : g[course]) {
                    inDeg[neighboor] --;
                    if (inDeg[neighboor] == 0) {
                        q.offer(neighboor);
                    }
                }
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            if (inDeg[i] > 0) {
                return new int[0];
            }
            res[i] = order.get(i);
        }
        return res;
    }
}
