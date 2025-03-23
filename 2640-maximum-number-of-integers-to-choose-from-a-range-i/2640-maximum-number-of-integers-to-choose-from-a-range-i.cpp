class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        vector<int> output;
        for(int i = 1; i<=n; i++){
            if (find(banned.begin(), banned.end(), i) != banned.end()) continue;
            output.push_back(i);
            int sum = accumulate(output.begin(), output.end(), 0);
            // cout << "--" << sum << "--" << i << "--" << endl;
            if (sum > maxSum) {
                output.pop_back();
                break;
            }
        }
        // for (int i : output) cout << i << endl;
        return output.size();
    }
};