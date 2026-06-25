class Solution {

    public boolean checker(int capacity, int[] weights, int days) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int i = 0; i < weights.length; i++) {

            if (currentWeight + weights[i] <= capacity) {
                currentWeight += weights[i];
            }
            else {
                requiredDays++;
                currentWeight = weights[i];
            }
        }

        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int start = Integer.MIN_VALUE;
        int end = 0;


        for (int i = 0; i < weights.length; i++) {
            start = Math.max(start, weights[i]);
            end += weights[i];
        }

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (checker(mid, weights, days)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}