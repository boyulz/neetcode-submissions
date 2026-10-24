class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
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
            ans = Math.max(y-x, ans);
        }
        return ans;
    }
}
