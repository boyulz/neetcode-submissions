class Solution {
    private final static int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int[] dir : DIRS) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == '1') {
                dfs(grid, x1, y1);
            }
        } 
    }
}
