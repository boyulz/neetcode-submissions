class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i ++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                left[i] = st.peek();
            } else {
                left[i] = -1;
            }
            st.push(i);
        }
        st.clear();
        for (int i = n-1; i >= 0; i --) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                right[i] = st.peek();
            } else {
                right[i] = n;
            }
            st.push(i);
        }
        
        int res = 0;
        for (int i = 0; i < n; i ++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
