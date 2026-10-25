class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = len - 1;
        int res = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            int minMax = Math.min(leftMax, rightMax);
            if (height[l] > height[r]) {
                res += minMax - height[r];
                r --;
            } else {
                res += minMax - height[l];
                l ++;
            }
        }
        return res;
    }
}
