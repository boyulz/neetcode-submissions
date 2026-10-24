class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int x2 = Integer.valueOf(st.pop());
                int x1 = Integer.valueOf(st.pop());
                st.push(x1 + x2);
            } else if (t.equals("-")) {
                int x2 = Integer.valueOf(st.pop());
                int x1 = Integer.valueOf(st.pop());
                st.push(x1 - x2);
            } else if (t.equals("*")) {
                int x2 = Integer.valueOf(st.pop());
                int x1 = Integer.valueOf(st.pop());
                st.push(x1 * x2);
            } else if (t.equals("/")) {
                int x2 = Integer.valueOf(st.pop());
                int x1 = Integer.valueOf(st.pop());
                st.push(x1 / x2);
            } else {
                st.push(Integer.valueOf(t));
            }
        }
        return st.pop();
    }
}
