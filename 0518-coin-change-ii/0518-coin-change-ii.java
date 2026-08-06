class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int row = 1; row <= n; row++) {

            int current = coins[row - 1];

            for (int sum = 1; sum <= amount; sum++) {

                dp[row][sum] = dp[row - 1][sum];

                if (current <= sum) {
                    dp[row][sum] += dp[row][sum - current];
                }

            }
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= amount; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[n][amount];
    }
}




