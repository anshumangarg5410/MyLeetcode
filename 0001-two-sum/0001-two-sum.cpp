class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int j = 0; vector<int> output;
        for(int i = j; i<=nums.size(); i++){
            if (nums[j] + nums[i] == target && i!=j) {
                output.push_back(j); output.push_back(i);
                return output;
            }
            if (i == nums.size() - 1) i = j++;
            if (j == nums.size()) break;
        }
        return output;

    }
};