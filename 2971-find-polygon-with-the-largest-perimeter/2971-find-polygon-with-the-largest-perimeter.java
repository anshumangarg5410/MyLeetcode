class Solution {
    public long largestPerimeter(int[] nums) {
        long sumSides = 0;
        int l = nums.length;

        for(int i : nums) {
            sumSides += i;
        }

        Arrays.sort(nums);

        for(int i = l - 1; i >= 2; i--) {
            long leftSum = sumSides - nums[i];

            if (leftSum > nums[i]) {
                return sumSides;
            }
            else {
                sumSides -= nums[i];
            }
        }

        return -1;
    }
}

