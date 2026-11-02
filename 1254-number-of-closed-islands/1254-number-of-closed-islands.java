class Solution {
    boolean[][] visited;
    int m;
    int n;
    public int bt(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (visited[i][j]) return 1;

        if (grid[i][j] == 1) return 1;

        visited[i][j] = true;

        int up = bt(grid, i - 1, j);
        int down = bt(grid, i + 1, j);
        int left = bt(grid, i, j - 1);
        int right = bt(grid, i, j + 1);

        return up * down * left * right;

    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        int count = 0;
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if (visited[i][j] || grid[i][j] == 1) continue;

                count += bt(grid, i, j);
            }
        }

        return count;


    }
}