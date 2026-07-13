class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int z = 0;
        int ans = 0;

        while (right < nums.length) {
            int current = nums[right];

            if (current == 1) {
                right++;
            }
            else {
                if (z >= 1) {
                    if (nums[left] == 0) {
                        left++;
                        z--;
                    }
                    else {
                        left++;
                    }
                }
                else {
                    z++;
                    right++;
                }
            }

            ans = Math.max(right - left - 1, ans);
        }

        return ans;
    }
}