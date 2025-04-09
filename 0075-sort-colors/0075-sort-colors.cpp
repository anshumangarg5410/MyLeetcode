class Solution {
public:
    void sortColors(vector<int>& nums) {
        // vector<int> zeroes;
        // vector<int> ones;
        // vector<int> twos;

        // for(int i = 0; i<nums.size();i++){
        //     if (nums[i] == 0) zeroes.push_back(0);
        //     else if (nums[i] == 1) ones.push_back(1);
        //     else twos.push_back(2);
        // }
        // nums.clear();

        // nums.insert(nums.end(), zeroes.begin(), zeroes.end());
        // nums.insert(nums.end(), ones.begin(), ones.end());
        // nums.insert(nums.end(), twos.begin(), twos.end());

        //better way

        //3 pointers approach 

        int start = 0, mid = 0, end = nums.size() - 1;
        while (mid <= end){
            if (nums[mid] == 0) swap(nums[start++], nums[mid++]);
            else if (nums[mid] == 2) swap(nums[end--],nums[mid]);
            else mid++;
        }
    }
};