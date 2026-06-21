class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0, ans = 0;

        if (costs[0] > coins) return 0;

        while (i < costs.length && costs[i] <= coins) {
            coins -= costs[i++];
            ans++;
        }

        return  ans;

    }
}