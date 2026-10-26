class Solution {
    boolean[][] visited;
    int m;
    int n;

    public long bt(int[][] grid, int i, int j, long sum) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        // System.out.println(sum + " " + grid[i][j] + " " + visited[i][j]);

        if (grid[i][j] == 0 || visited[i][j]) {
            // System.out.println("ZEROOOO");
            return 0;
        }

        visited[i][j] = true;

        long left = bt(grid, i, j - 1, sum + grid[i][j]);
        long right = bt(grid, i, j + 1, sum + grid[i][j]);
        long top = bt(grid, i - 1, j, sum + grid[i][j]);
        long down = bt(grid, i + 1, j, sum + grid[i][j]);

        return grid[i][j] + left + right + top + down;

    }

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                long sum = bt(grid, i, j, 0);

                if (sum != 0 && sum %k == 0) count++;
            }
        }

        return count;
    }
}