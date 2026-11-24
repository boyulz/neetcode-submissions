class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(1, i, j, board, visited, word)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int x, int y, char[][] board, boolean[][] visited, String word) {
        if (i == word.length()) {
            return true;
        }

        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny] && board[nx][ny] == word.charAt(i)) {
                visited[nx][ny] = true;
                if (dfs(i+1, nx, ny, board, visited, word)) {
                    return true;
                }
                visited[nx][ny] = false;
            }
        }
        return false;
    }
}
