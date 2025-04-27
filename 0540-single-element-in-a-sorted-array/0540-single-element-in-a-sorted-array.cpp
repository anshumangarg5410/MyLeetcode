class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int result = 0;
        for(int i : nums) result ^= i;
        return result;
    }
};