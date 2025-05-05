class Solution {
public:
    int singleNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        if (nums.size() <= 3) return nums[0];
        for(int i = 0; i<nums.size(); i++){
            cout << nums[i] << endl;
            if (i > 0 && i < nums.size() - 1){
                if (nums[i-1] != nums[i] && nums[i] != nums[i+1]) {
                cout << nums[i] << endl;
                return nums[i];
                }
            }
            else if (i == 0) {
                if (nums[i] != nums[i+1]) {
                cout << nums[i] << endl;
                return nums[i];
                }
            }
            else {
                if (nums[i-1] != nums[i]) {
                cout << nums[i] << endl;
                return nums[i];
                }
            }
        }
        return 0;
        // unordered_map<int, int> freq;
        // for(int i = 0; i<nums.size(); i++){
        //     freq[nums[i]]++;
        // }

    }

};

