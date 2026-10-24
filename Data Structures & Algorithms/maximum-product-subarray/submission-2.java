class Solution {
    // min[i] = Math.min(min[i-1] * nums[i], max[i-1] * nums[i], nums[i])
    // max[i] = Math.max(min[i-1] * nums[i], max[i-1] * nums[i], nums[i]) 
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] max = new int[n+1];
        int[] min = new int[n+1];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            min[i+1] = Math.min(Math.min(min[i] * nums[i], max[i] * nums[i]), nums[i]);
            max[i+1] = Math.max(Math.max(min[i] * nums[i], max[i] * nums[i]), nums[i]);
            ans = Math.max(ans, max[i+1]);
        }
        return ans;
    }
}
