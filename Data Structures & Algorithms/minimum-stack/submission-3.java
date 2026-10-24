class MinStack {
    Deque<Integer> min;
    Deque<Integer> st;
    public MinStack() {
        min = new ArrayDeque<>();
        st = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
        // System.out.println("new min: " + min.peek());
    }
    
    public void pop() {
        // System.out.println(st.peek());
        // System.out.println(min.peek());
        int val = st.pop();
        if (min.peek() == val) {
            // System.out.println("min change");
            min.pop();
        }
        // System.out.println("new min: " + min.peek());
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
