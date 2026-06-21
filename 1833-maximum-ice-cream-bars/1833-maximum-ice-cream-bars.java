class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for(int i : costs) System.out.print(i + " ");
        System.out.println();
        int i = 0, ans = 0;

        if (costs[0] > coins) return 0;

        while (i < costs.length && costs[i] <= coins) {
            coins -= costs[i++];
            System.out.println(" " + coins);
            ans++;
        }

        return  ans;

    }
}