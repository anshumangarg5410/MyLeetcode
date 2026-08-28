class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int current = nums[i];

            if (current > pivot) {
                after.add(current);
            }
            else if (current < pivot) {
                before.add(current);
            }
            else {
                equal.add(current);
            }
        }

        int i = 0;

        for (int x : before) nums[i++] = x;
        for (int x : equal) nums[i++] = x;
        for (int x : after) nums[i++] = x;

        return nums;

    }
}