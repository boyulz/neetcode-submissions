class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        int max = 0;
        while (l < r) {
            max = Math.max(Math.min(heights[l], heights[r]) * (r - l), max);
            if (heights[l] >= heights[r]) {
                r --;
            } else {
                l ++;
            }
        }
        return max;
    }
}
