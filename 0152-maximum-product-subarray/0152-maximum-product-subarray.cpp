class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        int prefix = 1; int suffix = 1; int maxi = nums[0];
        for(int i = 0; i<nums.size(); i++){
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[nums.size() -i-1];
            maxi = max(maxi, max(prefix, suffix));
        }
        return maxi;
    }
};