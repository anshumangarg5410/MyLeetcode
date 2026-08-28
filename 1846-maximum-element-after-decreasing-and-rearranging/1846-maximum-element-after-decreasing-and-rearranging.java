class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        if (arr[0] != 1) arr[0] = 1; 

        for(int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            if (diff > 1) {
                arr[i] = arr[i] - (diff - 1);
            }
        }

        return arr[n-1];
    }
}