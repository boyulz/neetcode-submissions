/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
        for (Interval interval : intervals) {
            pq.add(interval);
        }
        while (!pq.isEmpty()) {
            Interval itv = pq.poll();
            if (!pq.isEmpty() && pq.peek().start < itv.end) {
                return false;
            }
        }
        return true;
    }
}
