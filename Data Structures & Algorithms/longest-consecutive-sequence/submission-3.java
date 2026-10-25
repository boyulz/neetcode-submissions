class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int n : nums) {
            set.add(n);
        }
        for (int x : set) {
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x;
            while (set.contains(y + 1)) {
                y ++;
            }
            res = Math.max(y-x+1, res);
        }
        return res;
    }
}
