class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum %k == 0 && i >= 1) return true;

            // && (i -  map.get(sum%k))  >= 2

            if (map.containsKey(sum % k) && (i -  map.get(sum%k))  >= 2) {
                // System.out.print("yes at : " + map.get(sum%k) + " with i : " + i);
                return true;
            }

            if (!map.containsKey(sum % k)) map.put(sum % k, i);
        }

        return false;

    }
}