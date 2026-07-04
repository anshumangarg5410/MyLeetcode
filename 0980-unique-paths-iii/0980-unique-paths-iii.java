class Solution {

    int ans = 0;

    public void bt(int[][]grid, int row, int col, int emptCells, boolean[][] visited) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }

        if (grid[row][col] == -1) return;
        if (visited[row][col]) return;

        if (grid[row][col] == 2) {
            // System.out.println("yes + " +  emptCells);
            if (emptCells == 0) {
                ans++;
            }
            return;
        }

        visited[row][col] = true;
        emptCells--;
        bt(grid, row , col + 1, emptCells, visited);
        bt(grid, row , col - 1, emptCells, visited);
        bt(grid, row + 1, col, emptCells, visited);
        bt(grid, row - 1, col, emptCells, visited);
        visited[row][col] = false;

    }

    public int uniquePathsIII(int[][] grid) {
        int noOfEmptyCells = 1;
        int startRow = 0, startCol = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    noOfEmptyCells++;
                }

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }

            }
        }

        // System.out.print(noOfEmptyCells);

        bt(grid, startRow, startCol, noOfEmptyCells, visited);

        return ans;

    }
}