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

        subsetsrec(nums, ans, temp, n + 1);
        temp.push_back(nums[n]);
        subsetsrec(nums, ans, temp, n + 1);
        temp.pop_back();
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> temp;

        subsetsrec(nums, ans, temp,  0);

        return ans;

    }
};