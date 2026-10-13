class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int half = nums.length / 2;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] *= -1;
        }

        Arrays.sort(nums);

        for(int i : nums){
            System.out.print(i + " ");
        }
        int i = 0;

        for(; i < half; i++) {
            ans -= nums[i] * nums[i];
        }

        for(; i < nums.length; i++) {
            ans += nums[i] * nums[i];
        }

        return ans;
    }
}