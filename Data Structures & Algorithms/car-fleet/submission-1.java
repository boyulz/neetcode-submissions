class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i ++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(position[a], position[b]));
        Deque<Double> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i --) {
            int idx = indices[i];
            double time = (double) (target - position[idx]) / speed[idx];
            while (st.isEmpty() || st.peek() < time) {
                st.push(time);
            }
        }
        return st.size();
    }
}
