class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int rslt = INT_MIN;
        for(vector<int> account : accounts){
            int count = 0;
            for(int i : account) count += i;
            rslt = max(count, rslt);
        }
        return rslt;
    }
};