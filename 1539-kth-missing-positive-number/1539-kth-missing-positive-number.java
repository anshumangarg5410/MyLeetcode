class Solution {
    public int findKthPositive(int[] arr, int k) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            int ind = arr[mid] - mid - 1;

            if (ind < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start + k;
    }
}