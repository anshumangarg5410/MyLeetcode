class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = n - 2; i >= 0; i--) {

            for(int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
        }

        int ans = 0;

        for(int i : dp) {
            ans = Math.max(i, ans);
        }

        return ans;
    }
}