class Solution {

    boolean[][] visited;
    boolean possible;

    public void helper(char[][] board, int r, int c) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;

        if (visited[r][c] || board[r][c] == 'X') {
            // System.out.println("EXITED AT i : " + r + " and j : " + c + " since it was X");
            return;
        }

        // System.out.println("I AM IN AT i : " + r + " AND j : " + c);

        visited[r][c] = true;

        if (r == 0 || c == 0 || r == board.length - 1 || c == board[0].length - 1) {
            // System.out.println("EXITED AT i : " + r + " and j : " + c + " and posible false");
            possible = false;
        }

        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {

                    possible = true;

                    boolean[][] before = new boolean[rows][cols];

                    for (int r = 0; r < rows; r++) {
                        before[r] = visited[r].clone();
                    }

                    helper(board, i, j);

                    if (possible) {
                        for (int r = 0; r < rows; r++) {
                            for (int c = 0; c < cols; c++) {

                                if (visited[r][c] && !before[r][c]) {
                                    board[r][c] = 'X';
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
}



