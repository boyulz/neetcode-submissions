class Solution {
    private static final int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] toPacific = new int[m][n];
        int[][] toAtlantic = new int[m][n];
        for (int i = 0; i < m; i ++) {
            dfsToPacific(heights, toPacific, i, 0);
            dfsToAtlantic(heights, toAtlantic, i, n-1);
        }
        for (int i = 0; i < n; i ++) {
            dfsToPacific(heights, toPacific, 0, i);
            dfsToAtlantic(heights, toAtlantic, m-1, i);
        }
        

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (toPacific[i][j] == 1 && toAtlantic[i][j] == 1) {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    res.add(coordinates);
                }
            }
        }
        return res;
    }

    private void dfsToPacific(int[][] heights, int[][] toPacific, int x, int y) {
        toPacific[x][y] = 1;
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < heights.length &&
                ny >= 0 && ny < heights[0].length &&
                heights[nx][ny] >= heights[x][y] &&
                toPacific[nx][ny] == 0) {
                
                dfsToPacific(heights, toPacific, nx, ny);
            }
        }
    }

    private void dfsToAtlantic(int[][] heights, int[][] toAtlantic, int x, int y) {
        toAtlantic[x][y] = 1;
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < heights.length &&
                ny >= 0 && ny < heights[0].length &&
                heights[nx][ny] >= heights[x][y] &&
                toAtlantic[nx][ny] == 0) {
                
                dfsToAtlantic(heights, toAtlantic, nx, ny);
            }
        }
    }
}
