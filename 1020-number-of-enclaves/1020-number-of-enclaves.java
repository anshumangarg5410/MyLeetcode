class Solution {
    boolean[][] visited;
    boolean[][] visited_n;

    public boolean dfs(int[][] grid, int r, int c) {
        if (r > grid.length - 1 || r < 0 || c > grid[0].length - 1 || c < 0) {
            return false;
        }

        if (visited[r][c] || grid[r][c] == 0) return true;

        visited[r][c] = true;

        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);

        return (up && down && left && right);
    }

    public int countOnes(int[][] grid, int r, int c) {
        if (r > grid.length - 1 || r < 0 || c > grid[0].length - 1 || c < 0) {
            return 0;
        }

        if (visited_n[r][c] || grid[r][c] == 0) return 0;

        visited_n[r][c] = true;

        // int up = countOnes(grid, r - 1, c) + 1;
        // int down = countOnes(grid, r + 1, c) + 1;
        // int left = countOnes(grid, r, c - 1) + 1;
        // int right = countOnes(grid, r, c + 1) + 1;

        // return up + down + left + right;
        
        return countOnes(grid, r - 1, c) + countOnes(grid, r + 1, c) + countOnes(grid, r, c - 1) + countOnes(grid, r, c + 1) + 1;
    }

    public int numEnclaves(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        visited_n = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    if (dfs(grid, i, j)) {
                        int count = countOnes(grid, i, j);
                        System.out.println("YES AT i: " + i + " and j: " + j + " with ones : " + count);
                        ans += count;
                    }
                }
            }
        }

        return ans;
    }
}