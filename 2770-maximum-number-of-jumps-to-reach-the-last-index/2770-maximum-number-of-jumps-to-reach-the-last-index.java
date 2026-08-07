class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 0;

        for(int i = nums.length - 1; i >= 0; i--) {
            boolean jumps = false;
            for(int j = i + 1; j < nums.length; j++) {
                if ( ((nums[j] - nums[i]) >= -target) && ((nums[j] - nums[i]) <= target) && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j]);
                    jumps = true;

                    // System.out.println("YES FOR" + i);
                }
            }

            if (jumps) dp[i]++;
        }

        // for(int i : dp) {
        //     System.out.println(i);
        // }

        return dp[0];
    }
}