class MinStack {
    Deque<Integer> min = new ArrayDeque<>();
    Deque<Integer> st = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        st.addLast(val);
        if (min.isEmpty() || val <= min.getLast()) {
            min.addLast(val);
        }
    }
    
    public void pop() {
        int val = st.removeLast();
        if (val == min.getLast()) {
            min.removeLast();
        }
    }
    
    public int top() {
        return st.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}
