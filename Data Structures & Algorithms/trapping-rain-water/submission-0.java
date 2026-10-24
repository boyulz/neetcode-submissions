class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < r) {
            int leftH = height[l];
            int rightH = height[r];
            leftMax = Math.max(leftMax, leftH);
            rightMax = Math.max(rightMax, rightH);
            if (leftH < leftMax) {
                ans += Math.min(leftMax, rightMax) - leftH;
            }
            if (rightH < rightMax) {
                ans += Math.min(leftMax, rightMax) - rightH;
            }
            if (leftH > rightH) {
                r --;
            } else {
                l ++;
            }
        }
        return ans;
    }
}
