class Solution {
    public int waysToMakeFair(int[] nums) {
        int oddSuffix = 0;
        int evenSuffix = 0;

        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenSuffix += nums[i];
            }
            else {
                oddSuffix += nums[i];
            }
        }

        int oddPrefix = 0;
        int evenPrefix = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenSuffix -= nums[i];
            }
            else {
                oddSuffix -= nums[i];
            }

            if (evenPrefix + oddSuffix == oddPrefix + evenSuffix) {
                ans++;
            }

            if (i % 2 == 0) {
                evenPrefix += nums[i];
            }
            else {
                oddPrefix += nums[i];
            }
        }

        return ans;
    }
}