class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        //binary search using flattened 1d array 

        // vector<int> flatarray;
        // for (int i = 0; i < matrix.size(); i++) for (int j = 0; j<matrix[0].size(); j++) flatarray.push_back(matrix[i][j]);
        // int start = 0; int end = flatarray.size() - 1;
        // while (start <= end) {
        //     int mid = start + (end - start)/2;

        //     if (flatarray[mid] == target) return true;
        //     else if (flatarray[mid] < target) start = mid + 1;
        //     else end = mid - 1;
        // }
        // return false;
        // -- * -- 

        // binary search using virtual 1d array 

        // int start = 0; int end = matrix[0].size() * matrix.size() - 1;
        // //row = i / col, col = i % cols 
        // int n = matrix[0].size();
        // while (start <= end) {
        //     int mid = start + (end - start)/2;

        //     if (matrix[mid/n][mid%n] == target) return true;
        //     else if (matrix[mid/n][mid%n] < target) start = mid + 1;
        //     else end = mid - 1;

        // }
        // return false;

        //row wise binary search 

        int cols = matrix[0].size();
        int rows = matrix.size();

        int r = 0;

        while (r < rows) {
            if (matrix[r][0] <= target && matrix[r][cols - 1] >= target) {
                int tc = 0, c = cols - 1;

                while (tc <= c) {
                    int mid = tc + (c - tc) / 2;
                    if (matrix[r][mid] == target) return true;
                    else if (matrix[r][mid] > target) c = mid - 1;
                    else tc = mid + 1;
                }
            }
            r++;
        }
        return false;


    }
};