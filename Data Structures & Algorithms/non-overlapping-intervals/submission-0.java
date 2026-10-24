class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] itv = pq.poll();
            while (!pq.isEmpty() && pq.peek()[0] < itv[1]) {
                ans ++;
                pq.poll();
            }
        }
        return ans;
    }
}
