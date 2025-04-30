class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        // for(int i = 0; i<nums.size(); i++) nums[i] = nums[i] * nums[i];
        // sort(nums.begin(), nums.end());
        // return nums;

        int s = nums.size(); int left = 0; int right = nums.size() - 1;
        vector<int> result;
        while (left <= right) {
            if (abs(nums[left]) > abs(nums[right])) {
                result.push_back(nums[left] * nums[left]);
                left++;
            }
            else {
                result.push_back(nums[right] * nums[right]);
                right--;
            }
        }
        reverse(result.begin(), result.end());
        return result;
    }
};