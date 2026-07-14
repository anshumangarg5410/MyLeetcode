class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for(int j = i; j < nums.length; j++) {
                tempSum += nums[j];

                if (tempSum == goal) {
                    ans++;
                }
                else if (tempSum > goal) break;
            }
        }
        
        return ans;
    }
}