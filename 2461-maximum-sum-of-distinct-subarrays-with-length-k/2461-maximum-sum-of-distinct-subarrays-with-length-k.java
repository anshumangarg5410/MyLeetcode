class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0, right = k;
        Map<Integer, Integer> dupNums = new HashMap<>();
        long prefixSum = 0;
        long ans = 0;

        for(int i = 0; i < right; i++) {
            prefixSum += (long)nums[i];
            dupNums.put(nums[i], dupNums.getOrDefault(nums[i], 0) + 1);
        }

        if (dupNums.size() == k) {
            ans = prefixSum;
        }

        while (right < nums.length) {
            int ch = nums[right++];
            int rem = nums[left++];

            if (dupNums.containsKey(rem)) {
                if (dupNums.get(rem) > 1) {
                    dupNums.put(rem, dupNums.get(rem) - 1);
                } 
                else {
                    dupNums.remove(rem);
                }
            }

            dupNums.put(ch, dupNums.getOrDefault(ch, 0) + 1);

            prefixSum -= (long)rem;
            prefixSum += (long)ch;

            if (dupNums.size() == k) {
                ans = Math.max(ans, prefixSum);
            }
        }

        return ans;
    }
}