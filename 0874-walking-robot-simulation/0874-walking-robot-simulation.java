class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<List<Integer>> obs = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        current.add(0);

        for (int i = 0; i < obstacles.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(obstacles[i][0]);
            temp.add(obstacles[i][1]);

            obs.add(new ArrayList<>(temp));
        }

        int direction = 0;
        int ans = 0;

        // 0 -> North
        // 1 -> East
        // 2 -> South
        // 3 -> West

        for (int i = 0; i < commands.length; i++) {
            int route = commands[i];

            if (route == -1) {
                direction = (direction + 1) % 4;
                continue;
            }
            else if (route == -2) {
                direction = (direction + 3) % 4;
                continue;
            }

            for (int walk = 0; walk < route; walk++) {

                int nx = current.get(0);
                int ny = current.get(1);

                if (direction == 0) ny++;
                else if (direction == 1) nx++;
                else if (direction == 2) ny--;
                else nx--;

                List<Integer> temp = new ArrayList<>();
                temp.add(nx);
                temp.add(ny);

                if (obs.contains(temp)) break;

                current.set(0, nx);
                current.set(1, ny);

                ans = Math.max(ans, current.get(0) * current.get(0) + current.get(1) * current.get(1));
            }
        }

        return ans;
    }
}