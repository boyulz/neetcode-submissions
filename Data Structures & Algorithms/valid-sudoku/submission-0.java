class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!checkThreeByThree(board, i, j)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (!checkHorAndVer(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkHorAndVer(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i ++) {
            if (i == y) {
                continue;
            }
            if (board[x][i] != '.' && board[x][i] == board[x][y]) {
                return false;
            }
        }

        for (int i = 0; i < board[0].length; i ++) {
            if (i == x) {
                continue;
            }
            if (board[i][y] != '.' && board[i][y] == board[x][y]) {
                return false;
            }
        }
        
        return true;
    }

    private boolean checkThreeByThree(char[][] board, int x, int y) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                int nx = x + i;
                int ny = y + j;
                if (board[nx][ny] != '.') {
                    if (set.contains(board[nx][ny])) {
                        return false;
                    }
                    set.add(board[nx][ny]);
                }
            }
        }
        return true;
    }
}
