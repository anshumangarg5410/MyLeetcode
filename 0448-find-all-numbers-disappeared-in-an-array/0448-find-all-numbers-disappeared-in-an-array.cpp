class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> newarray;
        for(int i = 0; i<nums.size(); i++){
            newarray.push_back(i+1);
        }
        sort(nums.begin(), nums.end());
        vector<int> result;
        set_difference(newarray.begin(), newarray.end(), nums.begin(), nums.end(), inserter(result, result.begin()));
        return result;

    }
};