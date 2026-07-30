class Solution {
    static int[] dp;

    int dpbt(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.max(nums[i] + dpbt(nums, i + 2) , dpbt(nums, i + 1));
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];    
        Arrays.fill(dp, -1);

        return dpbt(nums, 0);
    }
}