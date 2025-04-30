class Solution {
public:

    int digitcounter(int n){
        int count = 0;
        while(n >= 1){
            n/= 10;
            count++;
        }
        return count;
    }
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for(int i = 0; i<nums.size(); i++){
            if (digitcounter(nums[i]) %2 == 0) {
                count++;
            }
        }
        return count;
    }
};