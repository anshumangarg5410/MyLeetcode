class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int n = grid.size();
        int lim = n * n;
        vector<int> count(lim + 1, 0);
        vector<int> reslt(2, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        for (int i = 1; i <= lim; i++) {
            if (count[i] == 2) reslt[0] = i;
            if (count[i] == 0) reslt[1] = i;
        }

        return reslt;
    }
};