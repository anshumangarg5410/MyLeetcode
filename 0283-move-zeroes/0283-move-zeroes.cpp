class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        // int count = 0;
        // for(int i = 0; i<nums.size(); i++) {
        //     if (nums[i] == 0) {
        //         nums.erase(nums.begin() + i);
        //         count++; i--;
        //     }
        // }
        // for(int i = 0; i<count; i++) nums.push_back(0);

        //logic 2
        // vector<int>output;
        // for(int i = 0; i<nums.size(); i++) if (nums[i] != 0) output.push_back(nums[i]);
        // int a = output.size();
        // for(int i = 0; i<nums.size() - a; i++) output.push_back(0);
        // for(int i = 0; i<nums.size(); i++) nums[i] = output[i];

        //logic 3
        int lastnz = 0;
        for(int i = 0; i<nums.size(); i++) if(nums[i] != 0) nums[lastnz++] = nums[i];
        for(int i = lastnz; i<nums.size(); i++) nums[i] = 0;
    }
};