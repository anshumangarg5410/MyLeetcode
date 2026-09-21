class Solution {

    class SmartGrid {
        int row;
        int col;
        int health;

        SmartGrid(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        health -= grid.get(0).get(0);
        if (health <= 0) return false;

        int[] nr = {0, 1, 0, -1};
        int[] nc = {1, 0, -1, 0};

        Queue<SmartGrid> q = new ArrayDeque<>();

        int[][] best = new int[m][n];
        for (int[] arr : best) Arrays.fill(arr, -1);

        best[0][0] = health;
        q.offer(new SmartGrid(0, 0, health));

        while (!q.isEmpty()) {
            SmartGrid current = q.poll();

            int row = current.row;
            int col = current.col;
            int hlth = current.health;

            // System.out.println(row + " " + col + " " + hlth);

            if (row == m - 1 && col == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int newR = row + nr[i];
                int newC = col + nc[i];

                if (newR < 0 || newC < 0 || newR >= m || newC >= n) continue;

                int newHealth = hlth - grid.get(newR).get(newC);

                if (newHealth <= 0) continue;

                if (newHealth > best[newR][newC]) {
                    best[newR][newC] = newHealth;
                    q.offer(new SmartGrid(newR, newC, newHealth));
                }
            }
        }

        return false;
    }
}

