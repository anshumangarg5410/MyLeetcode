class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int[] count = new int[n + 1];
        count[0] = 1;

        int sum = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum >= goal) {
                ans += count[sum - goal];
            }

            count[sum]++;
        }

        return ans;
    }
}