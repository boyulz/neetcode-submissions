class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i ++) {
            while (!stack.isEmpty() && temperatures[stack.getLast()] < temperatures[i]) {
                int prevDay = stack.removeLast();
                res[prevDay] = i - prevDay;
            }
            stack.addLast(i);
        }
        return res;
    }
}
