class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int ans = 0;
        if (n == 0) return 0;

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        // for(int[] i : pairs) {
        //     System.out.println(i[0] + " and " + i[1]);
        // }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = n - 2; i >= 0; i--) {
            
            for(int j = i + 1; j < n; j++) {
                if (pairs[j][0] > pairs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }

        for(int i : dp) {
            ans = Math.max(ans, i);
        }

        return ans;
    }
}