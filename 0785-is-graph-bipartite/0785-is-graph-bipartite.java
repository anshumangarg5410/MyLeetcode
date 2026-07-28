class Solution {

    int[] color;
    boolean[] visited;

    public boolean dfs(int[][] graph, int node, int prevNode, int colorPres) {

        visited[node] = true;
        color[node] = colorPres;
        colorPres = colorPres == 1 ? 0 : 1;

        // System.out.print(node + " ");
        

        for(int i = 0; i < graph[node].length; i++) {
            int next = graph[node][i];
            // System.out.println(next + " And " + prevNode);

            if (visited[next]) {
                if (next != prevNode) {
                    if (color[next] == color[node]) {
                        // System.out.println("NOT VALID");
                        return false;
                    }   
                    else {
                        // System.out.println("1 ELSE");
                        continue;
                    }
                }
                else {
                    // System.out.println("2ND ELSE");
                    continue;
                }
            }

            if (!dfs(graph, next, node, colorPres)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        visited = new boolean[graph.length];
        // boolean ans = dfs(graph, 0, -1, 0);

        for(int i = 0; i < visited.length; i++) {
            // System.out.print(visited[i] + " ");
            if (!visited[i]) {
                if (!dfs(graph, i, -1, 0)) return false;
            }
        }


        return true;

    }
}