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
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
        for (Interval interval : intervals) {
            pq.add(interval);
        }
        int room = 0;
        PriorityQueue<Integer> available = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Interval i  = pq.poll();
            if (available.isEmpty() || available.peek() > i.start) {
                room ++;
                available.add(i.end);
            } else {
                available.poll();
                available.add(i.end);
            }
        }
        return room;
    }
}
