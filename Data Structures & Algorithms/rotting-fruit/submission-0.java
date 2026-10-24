class Solution {
    private static int[][] DIRS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    fresh ++;
                }
                else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time ++;
            for (int i = 0; i < size; i ++) {
                int[] rotten = q.poll();
                int x = rotten[0];
                int y = rotten[1];
                for (int[] dir : DIRS) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        fresh --;
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}
