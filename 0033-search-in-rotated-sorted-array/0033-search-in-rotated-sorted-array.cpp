class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0; int last = nums.size() - 1;
        while (start <= last){
            int mid = start + (last - start)/2;

            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && nums[mid] >= target) last = mid - 1;
                else start = mid + 1;
            }
            else {
                if (nums[mid] <= target && nums[last] >= target) start = mid + 1;
                else last = mid - 1;
            }
        } return -1;
    }
};