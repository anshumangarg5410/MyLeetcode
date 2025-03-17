class Solution {
public:
    bool divideArray(vector<int>& nums) {
        int n = nums.size();
        for(int i = 0; i<nums.size(); i++){
            if (count(nums.begin(), nums.end(), nums[i]) %2 != 0) return false; 
        }
        return true;
    }
};