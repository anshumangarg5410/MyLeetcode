class Solution {
    public boolean check(int[] nums) {
        int flag = 0, n = nums.length;

        for(int i = 0; i < n; i++) {
            if (nums[i] > nums[(i+1) % n]) {
                flag++;
            }

            if (flag > 1) return false;
        }

        return true;
    }
}