class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            res = Math.max(Math.min(heights[l], heights[r])*(r-l), res);
            if (heights[l] > heights[r]) {
                r --;
            } else {
                l ++;
            }
        }
        return res;
    }
}
