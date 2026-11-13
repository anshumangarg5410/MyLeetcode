class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxwater = 0;

        while (start < end) {
            if (height[start] > height[end]) {
                maxwater = Math.max(maxwater, height[end] * (end - start));
                end--;
            } else {
                maxwater = Math.max(maxwater, height[start] * (end - start));
                start++;
            }
        }

        return maxwater;
    }
}