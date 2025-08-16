class Solution {
public:
    vector<long long> findPrefixScore(vector<int>& nums) {
        vector<long long> result (nums.size(), 0);
        int maxele = nums[0];
        result[0] = nums[0] * 2;
        for (int i = 1; i<nums.size(); i++) {
            maxele = max(nums[i], maxele); 
            result[i] +=  result[i-1] + (maxele + nums[i]);
        }
        return result;
        
    }
};