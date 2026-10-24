class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (c == ')') {
                    if (st.peek() != '(') {
                        return false;
                    } else {
                        st.pop();
                    }
                } else if (c == ']') {
                    if (st.peek() != '[') {
                        return false;
                    } else {
                        st.pop();
                    }
                } else {
                    if (st.peek() != '{') {
                        return false;
                    } else {
                        st.pop();
                    }
                }
            }
        }
        return st.isEmpty();
    }
}
