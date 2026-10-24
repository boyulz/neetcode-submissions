class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i ++) {
            int t = temperatures[i];
            while (!st.isEmpty() && temperatures[st.peek()] < t) {
                int day = st.pop();
                res[day] = i - day;
            }
            st.push(i);
        }
        return res;
    }
}
