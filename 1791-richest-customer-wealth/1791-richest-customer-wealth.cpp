class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int rslt = INT_MIN;
        for(int i = 0; i<accounts.size(); i++){
            int count = 0;
            for(int j = 0; j<accounts[i].size(); j++) count += accounts[i][j];
            rslt = max(count, rslt);
        }
        return rslt;
    }
};