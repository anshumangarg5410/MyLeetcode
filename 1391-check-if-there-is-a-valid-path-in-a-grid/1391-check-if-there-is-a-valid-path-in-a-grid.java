class Solution {

    int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int opposite(int d) {

        if (d == 0) return 1;
        if (d == 1) return 0;
        if (d == 2) return 3;

        return 2;
    }

    public boolean canMove(int type, int dir) {

        if (type == 1) return dir == 0 || dir == 1;
        if (type == 2) return dir == 2 || dir == 3;
        if (type == 3) return dir == 1 || dir == 2;
        if (type == 4) return dir == 0 || dir == 2;
        if (type == 5) return dir == 1 || dir == 3;

        return dir == 0 || dir == 3;
    }

    public boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        if (i == m - 1 && j == n - 1) return true;

        vis[i][j] = true;

        for (int d = 0; d < 4; d++) {

            int ni = i + dir[d][0];
            int nj = j + dir[d][1];

            if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;

            if (vis[ni][nj]) continue;

            if (canMove(grid[i][j], d) && canMove(grid[ni][nj], opposite(d))) {
                if (dfs(grid, ni, nj, vis)) return true;
            }
        }

        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        return dfs(grid, 0, 0, vis);
    }
}