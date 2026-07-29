class Solution {
    boolean[] visiting;
    boolean[] safe;

    private boolean dfs(int node, int[][] graph) {
        if (visiting[node]) return false; 
        if (safe[node]) return true;      

        visiting[node] = true;

        for (int next : graph[node]) {
            if (!dfs(next, graph)) {
                visiting[node] = false;
                return false;
            }
        }

        visiting[node] = false;
        safe[node] = true;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        visiting = new boolean[graph.length];
        safe = new boolean[graph.length];

        for (int node = 0; node < graph.length; node++) {
            if (dfs(node, graph)) {
                result.add(node);
            }
        }

        return result;
    }
}