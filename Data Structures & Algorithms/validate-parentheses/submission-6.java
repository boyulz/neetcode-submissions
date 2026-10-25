class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.addLast(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.getLast();
                if ((ch == ')' && top == '(') || 
                    (ch == '}' && top == '{') || 
                    (ch == ']' && top == '[')) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
