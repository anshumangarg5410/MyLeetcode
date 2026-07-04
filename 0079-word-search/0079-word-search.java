class Solution {
    boolean cond = false;

    private void bt(char[][] board, String word, int m, int n,int i, int j, int idx, boolean[][] used) {

        if (cond) return; 
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (used[i][j]) return;
        if (board[i][j] != word.charAt(idx)) return;

        if (idx == word.length() - 1) {
            cond = true;
            return;
        }

        used[i][j] = true;

        bt(board, word, m, n, i + 1, j, idx + 1, used);
        bt(board, word, m, n, i - 1, j, idx + 1, used);
        bt(board, word, m, n, i, j + 1, idx + 1, used);
        bt(board, word, m, n, i, j - 1, idx + 1, used);

        used[i][j] = false; 
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bt(board, word, m, n, i, j, 0, used);
                if (cond) return true;
            }
        }
        return false;
    }
}