class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> result(nums.size(), 1);
        long long int prod = 1;
        for(int i = 1; i<nums.size(); i++){
            prod *= nums[i-1];
            result[i] = prod;
        }
        prod = 1;
        for(int i = nums.size()-2; i >= 0; i--){
            prod *= nums[i+1];
            result[i] *= prod;
        }

        for(int i : result) cout << i << " ";
        return result;
    }
};