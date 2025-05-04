class Solution {
public:
    int countSubarrays(vector<int>& nums) {
        int count = 0;
        for(int i = 0; i<nums.size()-2; i++){
            float target = float(nums[i+1])/2.00;
            float first = float(nums[i]) + float(nums[i+2]);
            if (target == first) count++;
        }
        return count;
    }
};