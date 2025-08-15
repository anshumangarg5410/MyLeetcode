class Solution {
public:
    bool canJump(vector<int>& nums) {
        int maxiterator = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > maxiterator) return false;
            maxiterator = max(maxiterator, i + nums[i]);
            if (maxiterator >= nums.size() - 1) return true;
        }
        return true;
    }
};