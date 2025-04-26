class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        // int start = 0; int end = nums.size() - 1;
        // while (start < nums.size()){
        //     if (end < 0) { 
        //         start++;
        //         end = nums.size() - 1;
        //         continue;
        //     }
        //     if (nums[start] == nums[end] && abs(start - end) <= k && start != end) {
        //         cout << start << "  " << end << endl;
        //         return true;
        //     }
        //     end--;
        // }
        // return false;
        //failed appraoch upper fali!

        // using unoderdered map !

        unordered_map<int, int> map;
        for(int i = 0; i<nums.size(); i++){
            if (map.count(nums[i])) {
                if (i - map[nums[i]] <= k) return true;
            }
            map[nums[i]] = i;
        }
        return false;
    }
};