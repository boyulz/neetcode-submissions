class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println(mid);
            if (matrix[mid/n][mid%n] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l < m*n && matrix[l/n][l%n] == target) {
            return true;
        } else {
            return false;
        }
    }
}
