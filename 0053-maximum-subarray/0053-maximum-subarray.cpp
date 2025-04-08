class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        // int sum = nums[0];
        // if (nums.size() == 1) return nums[0];
        // for(int i = 0; i<nums.size();i++){
        //     int newsum = 0;
        //     for(int j = i; j<nums.size();j++){
        //         newsum += nums[j];
        //         if (newsum > sum) sum = newsum;
        //     }
        // }
        // return sum;

        int summ = 0; int finalsumm = INT_MIN;
        for(int i = 0; i<nums.size(); i++){
            summ += nums[i];
            finalsumm = max(finalsumm, summ);
            if (summ < 0) summ = 0;
        }
        return finalsumm;
    }
};