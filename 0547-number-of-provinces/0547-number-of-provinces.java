class Solution {
    boolean[] visited;

    public void dfs(int node, int[][] isConnected) {

        if (visited[node]) return;

        visited[node] = true;

        for(int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[node][i] == 1) {
                dfs(i, isConnected);
            }
        }

    }
    
    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int ans = 0;
        int n = isConnected.length;

        for(int i = 0; i < n; i++) {

            if (!visited[i]) {
                ans++;
                dfs(i, isConnected);
            }
        }

        return ans;
    }
}