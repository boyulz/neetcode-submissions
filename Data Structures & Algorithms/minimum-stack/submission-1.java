class MinStack {
    Deque<Integer> min = new ArrayDeque<>();
    Deque<Integer> st = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        st.push(val);
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }
    
    public void pop() {
        int remove = st.pop();
        if (min.peek() == remove) {
            min.poll();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
