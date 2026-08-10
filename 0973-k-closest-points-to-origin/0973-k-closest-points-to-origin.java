class Solution {

    public double EuclideanDist(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        double[][] arr = new double[points.length][2];

        for(int i = 0; i < points.length; i++) {
            arr[i][0] = EuclideanDist(points[i][0], points[i][1]);
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " at " + arr[i][1]);
        }

        int[][] ans = new int[k][1];

        for(int i = 0; i < k; i++) {
            ans[i] = points[(int)arr[i][1]];
        }

        return ans;
    }
}