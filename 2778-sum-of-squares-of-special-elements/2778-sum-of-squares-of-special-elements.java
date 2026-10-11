class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0; 

        for(int i = 1; i <= nums.length; i++) {
            ans += nums.length % i == 0 ? nums[i-1]*nums[i-1] : 0;
        }

        return ans;
    }
}