class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) ->
            Double.compare((double) dist[i] / speed[i], (double) dist[j] / speed[j])
        );

        int time = 0, monsterKilled = 0;
        for(int i = 0; i < n; i++) {
            int ind = indices[i];
            int distCovered = speed[ind] * time;
            int newDist = dist[ind] - distCovered;

            if (newDist <= 0) return monsterKilled;
            else {
                monsterKilled++;
                time++;
            }
        }

        return monsterKilled;

    }
}