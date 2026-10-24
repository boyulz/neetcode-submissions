class Solution {
    private static int[][] DIRS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] grid, int x, int y, int distance) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if (nx >= 0 && nx < m && ny >= 0 && ny < n 
                && grid[nx][ny] > distance + 1) {
                
                grid[nx][ny] = distance + 1;
                dfs(grid, nx, ny, distance + 1);
            }
        }
    }
}