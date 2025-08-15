class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        // int start = 0; int end = nums.size()-1;
        vector<int> result = {-1,-1};
        auto lower = lower_bound(nums.begin(), nums.end(), target);
        auto upper = upper_bound(nums.begin(), nums.end(), target);
        if (lower != nums.end() && *lower == target) {
            result[0] = lower - nums.begin();
            result[1] = upper - nums.begin() - 1;
        }

        // //first
        // while (start <= end) {
        //     int mid = start + (end - start)/2;

        //     if (nums[mid] < target) start = mid + 1;
        //     else end = mid - 1;
        // }
        // if (start >= nums.size() || nums[start] != target) return result;
        // result[0] = start;

        // //second
        // start = 0; end = nums.size()-1;
        // while (start <= end) {
        //     int mid = start + (end - start)/2;

        //     if (nums[mid] > target) end = mid - 1;
        //     else start = mid + 1;
        // }
        // result[1] = end;

        return result; 



    }
};