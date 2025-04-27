class Solution {
public:
    int arraySign(vector<int>& nums) {
        int result = 1;
        for(int i : nums) {
            if (i > 0) result *= 1;
            else if (i < 0) result *= -1;
            else return 0;
        }
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }
};