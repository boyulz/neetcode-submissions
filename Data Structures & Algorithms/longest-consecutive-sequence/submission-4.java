class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int x = nums[i];
            int y = nums[i];
            while (i+1 < n && (nums[i+1] == y || nums[i+1] == y+1)) {
                i ++;
                y = nums[i];
            }
            ans = Math.max(ans, y-x+1);
        }
        return ans;
    }
}
