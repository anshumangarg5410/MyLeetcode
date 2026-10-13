class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int m = bookings.length;

        int[] ans = new int[n];

        for(int i = 0; i < m; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;

            for(int j = start; j <= end; j++) {
                ans[j] += bookings[i][2];
            }
        }

        return ans;
    }
}