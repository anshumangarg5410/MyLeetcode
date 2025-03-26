class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        // set<int> myset(nums.begin(), nums.end());
        // myset.insert(target);
        // auto index = find(myset.begin(), myset.end(), target);
        // return distance(myset.begin(), index);
        //BETTER APPROACH USE BINARY SEARCH.. YET TO LEARN !! 

        int start = 0; int last = nums.size() - 1;
        while (start <= last){
            int mid = start + (last - start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                last = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;

    }
};