class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        int i = 0;
        vector<int>bin;
        vector<int> result;
        for (i=0; i < 32; i++) {
            if ((1 << i) & n) {
                bin.push_back(1 << i);
            }
        }
        for (int i : bin) cout << i;
        const int MOD = 1000000007;
        for (int i = 0; i<queries.size(); i++) {
            long long product = 1;
            for (int j = queries[i][0]; j<=queries[i][1]; j++) {
                product = (product * bin[j]) % MOD; 
            }
            result.push_back(product % MOD);
        }

        return result;
 
    }
};