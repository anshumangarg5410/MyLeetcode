import java.util.*;

class Solution {

    class Orange {
        int row;
        int col;

        Orange(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Orange> q = new LinkedList<>();
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Orange(i, j));
                }
            }
        }

        int r = grid.length;
        int c = grid[0].length;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean r_Min = false;

            for (int i = 0; i < size; i++) {
                Orange crnt = q.poll();
                int row = crnt.row;
                int col = crnt.col;

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    q.offer(new Orange(row - 1, col));
                    r_Min = true;
                }

                if (row + 1 < r && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    q.offer(new Orange(row + 1, col));
                    r_Min = true;
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    q.offer(new Orange(row, col - 1));
                    r_Min = true;
                }

                if (col + 1 < c && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    q.offer(new Orange(row, col + 1));
                    r_Min = true;
                }
            }

            if (r_Min) ans++;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }
}