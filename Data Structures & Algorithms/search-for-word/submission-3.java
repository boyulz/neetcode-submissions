class Solution {
    private static int[][] DIRS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] vis = new boolean[m][n];
                    if (bt(board, 0, i, j, word, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bt(char[][] board, int k, int x, int y, String word, boolean[][] vis) {
        if (k == word.length() - 1 && board[x][y] == word.charAt(k)) {
            return true;
        }
        if (board[x][y] != word.charAt(k)) {
            return false;
        }
        vis[x][y] = true;
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !vis[nx][ny]) {
                if (bt(board, k+1, nx, ny, word, vis)) {
                    return true;
                }
            }
        }
        vis[x][y] = false;
        return false;
    }
}
