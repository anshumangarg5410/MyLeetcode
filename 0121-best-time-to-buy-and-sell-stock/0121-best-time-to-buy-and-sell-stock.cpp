class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0; int buy = prices[0];
        for(int i = 1; i<prices.size(); i++){
            if (prices[i] > buy){
                profit = max(profit, abs(prices[i] - buy));
            }
            buy = min(buy, prices[i]);
        }
        return profit;
    }
};