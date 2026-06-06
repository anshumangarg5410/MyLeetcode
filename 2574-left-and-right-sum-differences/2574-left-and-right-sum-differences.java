class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = nums.length - 2; i >= 0; i--) {
            ans[i] = ans[i+1] + nums[i+1];
        }

        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(ans[i] - sum);

            sum += nums[i];
        }

        return ans;
    }
}