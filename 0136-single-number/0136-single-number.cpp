class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // for(int i = 0; i<nums.size(); i++){
        //     if (count(nums.begin(), nums.end(), nums[i]) == 1) return nums[i];
        // }
        // return 0;

        //better sol!
        int ans=0;
        for(int i=0;i<nums.size();i++) ans^=nums[i];
        return ans;
    }
};