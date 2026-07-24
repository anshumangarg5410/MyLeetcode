class Solution {

    boolean[] visited;

    public void dfs(List<List<Integer>> rooms, int node) {
        if (visited[node]) return;

        visited[node] = true;

        for(int i = 0; i < rooms.get(node).size(); i++) {
            dfs(rooms, rooms.get(node).get(i));
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);

        boolean ans = true;

        for(boolean i : visited) {
            if (i == false) {
                return false;
            }
        }

        return true;
    }
}