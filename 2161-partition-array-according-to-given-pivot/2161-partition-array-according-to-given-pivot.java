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

        while (!before.isEmpty()) {
            nums[i] = before.remove(0);
            i++;
        }

        while (!equal.isEmpty()) {
            nums[i] = equal.remove(0);
            i++;
        }

        while (!after.isEmpty()) {
            nums[i] = after.remove(0);
            i++;
        }

        return nums;

    }
}