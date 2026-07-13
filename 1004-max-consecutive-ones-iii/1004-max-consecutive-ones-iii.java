class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int tempK = k;
        int ans = 0;
        int oldestOne = 0;
        boolean oldestOneB = false;

        while (right < nums.length) {
            int current = nums[right];

            if (current == 1) {
                right++;
            }
            else {
                if (tempK > 0) {
                    right++;
                    tempK--;
                }
                else {
                    if (nums[left] == 0) {
                        tempK++;
                    }
                    left++;
                }
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}