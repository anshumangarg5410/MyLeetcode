class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        set<int> myset(nums.begin(), nums.end());
        myset.insert(target);
        auto index = find(myset.begin(), myset.end(), target);
        return distance(myset.begin(), index);
    }
};