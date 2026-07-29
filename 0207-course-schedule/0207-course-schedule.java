class Solution {

    HashMap<Integer, ArrayList<Integer>> map;
    boolean[] visited;
    boolean[] checked;
    boolean ans;

    public void dfs(int currentCourse) {

        if (visited[currentCourse]) {
            // System.out.print("false at " + currentCourse);
            ans = false;
            return;
        }

        if (checked[currentCourse]) return;

        visited[currentCourse] = true;

        if (map.containsKey(currentCourse)) {

            List<Integer> prereq = map.get(currentCourse);

            for (int i = 0; i < prereq.size(); i++) {
                dfs(prereq.get(i));

                if (ans == false) return;
            }
        }

        visited[currentCourse] = false;
        checked[currentCourse] = true;
    }

    // [[1,0], [1,2], [0, 2], [2, 1]]

    // 1: [0, 2];
    // 0: [2]
    // 2: [1];

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        map = new HashMap<>();
        visited = new boolean[numCourses];
        checked = new boolean[numCourses];
        ans = true;

        for (int i = 0; i < prerequisites.length; i++) {

            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            else {
                map.put(prerequisites[i][0], new ArrayList<>());
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }

        // System.out.print(map.size());

        for (int i = 0; i < numCourses; i++) {
            dfs(i);

            if (ans == false) return false;
        }

        return true;
    }
}