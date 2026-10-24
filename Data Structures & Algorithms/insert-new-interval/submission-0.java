class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        pq.add(newInterval);
        List<int[]> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            while (!pq.isEmpty() && pq.peek()[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], pq.peek()[1]);
                pq.poll();
            }
            res.add(temp);
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i ++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
