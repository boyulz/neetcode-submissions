class Solution {
    private int[][] pacific;
    private int[][] atlantic;
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        pacific = new int[m][n];
        atlantic = new int[m][n];

        for (int i = 0; i < m; i++) dfs(heights, i, 0, pacific);
        for (int j = 0; j < n; j++) dfs(heights, 0, j, pacific);

        for (int i = 0; i < m; i++) dfs(heights, i, n-1, atlantic);
        for (int j = 0; j < n; j++) dfs(heights, m-1, j, atlantic);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int x, int y, int[][] canReach) {
        canReach[x][y] = 1;

        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && ny >= 0 && nx < heights.length && ny < heights[0].length 
                && canReach[nx][ny] == 0 && heights[nx][ny] >= heights[x][y]) {
                dfs(heights, nx, ny, canReach);
            }
        }
    }
}