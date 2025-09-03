class Solution {
public:

    void subsetsrec(vector<int> &nums, vector<vector<int>> &ans, vector<int> &temp, int n) {
        if (n == nums.size()) {
            vector<int> ultratemp;
            for (int i : temp) {
                ultratemp.push_back(i);
            }
            ans.push_back(ultratemp);
            return;
        }

        temp.push_back(nums[n]);
        subsetsrec(nums, ans, temp, n + 1);
        
        temp.pop_back();

        int idx = n + 1;
        while (idx < nums.size() && nums[idx] == nums[idx - 1] ) idx++;
        subsetsrec(nums, ans, temp, idx);
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> temp;

        subsetsrec(nums, ans, temp,  0);

        return ans;

    }
};