class Solution {

    public boolean checker(int[] nums, int maxSum, int k) {

        int subArrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (num > maxSum)
                return false;

            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subArrays++;
                currentSum = num;
            }
        }

        return subArrays <= k;
    }

    public int splitArray(int[] nums, int k) {

        int start = 0;
        int end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        int ans = end;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (checker(nums, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}