class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, val = 0;

        for(int i = 0; i < gain.length; i++) {
            ans = Math.max(val + gain[i], ans);
            val = val + gain[i];
            gain[i] = val + gain[i];
        }

        return ans;
    }
}