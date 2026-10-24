class Solution {
    private static int[][] DIRS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i ++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m-1][i] == 'O') {
                dfs(board, m-1, i);
            }
        }
        for (int i = 1; i < m-1; i ++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y] = 'A';
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'O') {
                dfs(board, nx, ny);
            }
        }
    }
}
