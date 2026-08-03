class Solution {

    Queue<SmartNumber> q;
    boolean[][] visited;

    class SmartNumber {

        int row;
        int col;
        int dist;

        SmartNumber(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        q = new LinkedList<>();
        visited = new boolean[n][n];

        q.offer(new SmartNumber(0, 0, 1));
        visited[0][0] = true;

        int[] rowDir = {-1,-1,-1,0,0,1,1,1};
        int[] colDir = {-1,0,1,-1,1,-1,0,1};

        while (!q.isEmpty()) {

            SmartNumber current = q.poll();

            int row = current.row;
            int col = current.col;
            int dist = current.dist;

            if (row == n - 1 && col == n - 1) return dist;

            for (int i = 0; i < 8; i++) {

                int newRow = row + rowDir[i];
                int newCol = col + colDir[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    q.offer(new SmartNumber(newRow, newCol, dist + 1));
                }
            }
        }

        return -1;
    }
}