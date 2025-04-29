class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> nnn;
        for(int i : nums) nnn.insert(i);
        if (nums.size() == nnn.size()) return false;
        return true;
    }
};