class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> Double.compare(
            ( points[j][0]*points[j][0] + points[j][1]*points[j][1]), (points[i][0]*points[i][0] + points[i][1]*points[i][1]) )
        );

        for(int i = 0; i < points.length; i++) {
            pq.add(i);

            if (pq.size() > k) {
                pq.poll();
            }

        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++) {
            int index = pq.poll();

            ans[i][0] = points[index][0];
            ans[i][1] = points[index][1];
        }

        return ans;


    }
}