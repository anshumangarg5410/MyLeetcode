class Solution {
    List<List<int[]>> paths;
    boolean[][] visited;
    int row;
    int col;
    boolean condition;


    public void bt(List<int[]> ongoingPath, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }

        if (condition) return;
        if (visited[i][j]) return;

        ongoingPath.add(new int[]{i, j});
        visited[i][j] = true;


        if (i == row - 1 && j == col - 1) {
            condition = true;
            paths.add(new ArrayList<>(ongoingPath));
            ongoingPath.remove(ongoingPath.size() - 1);
            visited[i][j] = false; 
            // System.out.print("yes " + i + " and " + j + " ");
            // for(int[] o : ongoingPath) {
            //     System.out.print(o[0] + " " + o[1] + ", ");
            // }
            // System.out.println();
            return;
        }



        bt(ongoingPath, i + 1, j);
        bt(ongoingPath, i, j - 1);
        bt(ongoingPath, i, j + 1);
        bt(ongoingPath, i - 1, j);

        ongoingPath.remove(ongoingPath.size() - 1);
        visited[i][j] = false; 
    }
    public String[] createGrid(int m, int n) {
        condition = false;
        paths = new ArrayList<>();
        visited = new boolean[m][n];
        List<int[]> ongoingPath = new ArrayList<>();
        row = m;
        col = n;

        char[][] grid = new char[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        bt(ongoingPath, 0, 0);

        String[] ans = new String[row];
        for(List<int[]> i : paths) {

            for(int[] j : i) {
                grid[j[0]][j[1]] = '.';
                // System.out.print(j[0] + " " + j[1] + ", ");
            }

            // System.out.println();
        }

        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int i = 0; i < m; i++) {
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < n; j++) {
                temp.append(grid[i][j]);
            }
            ans[i] = temp.toString();
        }

        return ans;
    }
}