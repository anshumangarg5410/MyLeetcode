class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> numscopy = nums;
            sort(numscopy.begin(), numscopy.end());  
        vector<vector<int>> result;
        result.push_back(numscopy);
        while (next_permutation(numscopy.begin(), numscopy.end())){
            result.push_back(numscopy);
        }
        return result;
    }
};