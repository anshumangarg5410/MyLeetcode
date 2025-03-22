class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        sort(nums.begin(), nums.end());
        while (find(nums.begin(), nums.end(), val) != nums.end()) nums.erase(find(nums.begin(), nums.end(), val));
        return nums.size();
    }
};