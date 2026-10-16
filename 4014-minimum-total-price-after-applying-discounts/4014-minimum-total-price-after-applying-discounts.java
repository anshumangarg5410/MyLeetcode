class Solution {

    public double newPrice(double p, double d) {
        return (p*(100-d))/100;
    }

    public double minPrice(int[] prices, int[] discounts) {
        
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double ans = 0;

        int p = prices.length - 1;
        int d = discounts.length - 1;


        for(int i = p; i >= 0; i--) {
            double newP = prices[i];

            if (d >= 0) newP = newPrice((double)prices[i], (double)discounts[d--]);

            ans += newP;
        }

        return ans;
    }
}