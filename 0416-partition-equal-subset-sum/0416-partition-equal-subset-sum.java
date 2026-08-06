class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1 ) return false;

        int sumArray = 0;
        for(int i = 0; i < nums.length; i++) sumArray += nums[i];

        if (sumArray %2 != 0) return false;

        int targetSum = sumArray /2 ;
        boolean[][] dp = new boolean[n+1][targetSum+1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j < targetSum + 1; j++) {
        //         if (dp[i][j] == true) System.out.print("1 ");
        //         else {
        //             System.out.print("0 ");
        //         }
        //     }
        //     System.out.println();
        // }

        for(int row = 1; row <= n; row++) {
            int current = nums[row - 1];

            for(int sum = 1; sum < targetSum+ 1; sum++) {

                if (current <= sum) {
                    dp[row][sum] = dp[row-1][sum] || dp[row-1][sum - current];
                }
                else {
                    dp[row][sum] = dp[row-1][sum];
                }

            }

        }

        return dp[n][targetSum];
        
    }
}