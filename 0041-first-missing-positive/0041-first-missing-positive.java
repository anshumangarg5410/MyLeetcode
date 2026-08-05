class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int num = 1;

        for(int i : nums) {
            if (i < num) continue;
            else {
                if (i == num) num++;
                else return num;
            }
        }

        return num;
    }
}