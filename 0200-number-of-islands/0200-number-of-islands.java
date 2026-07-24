class Solution {

    boolean[][] visited;

    // public boolean dfs(char[][] grid, int i, int j, char direction) {
    //     System.out.println("MOVING AT : " + i + " AND " + j);
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
    //         return true;
    //     }

    //     if (visited[i][j]) {
    //         return false;
    //     }

    //     if (grid[i][j] == 1) {
    //         dfs()
    //     }

    //     if (grid[i][j] == 0) {
    //         return true;
    //     }

    //     System.out.println(" SUCCEDD!");

    //     boolean up = dfs(grid, i - 1, j, up);
    //     boolean down = dfs(grid, i + 1, j, down);
    //     boolean right = dfs(grid, i, j + 1, right);
    //     boolean left = dfs(grid, i, j - 1, left)

    // }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

        if (grid[i][j] == '0' || visited[i][j]) return;

        visited[i][j] = true;

        dfs(grid, i - 1, j); 
        dfs(grid, i + 1, j); 
        dfs(grid, i, j - 1); 
        dfs(grid, i, j + 1);

    }

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        // System.out.println("final = " + dfs(grid, 0, 0));


        return ans;

    }
}