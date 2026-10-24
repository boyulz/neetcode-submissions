class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int x : set) {
            if (set.contains(x-1)) {
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) {
                y ++;
            }
            res = Math.max(y-x, res);
        }
        return res;
    }
}
