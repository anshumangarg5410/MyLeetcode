class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = prices[0]; int profit = 0;
        for(int i = 0; i<prices.size(); i++) {
            int temp = 0;
            if(i != prices.size() - 1) buy = min(buy, prices[i]);
            if (buy != prices[i] && prices[i] >= buy) {
                temp = prices[i] - buy;
            }
            profit = max(temp, profit);
        }
        return profit;
    }
};