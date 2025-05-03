class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int rslt = 0;
        int row = mat.size();
        int col = mat[0].size();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if (i == j || i + j == row-1) rslt += mat[i][j];
            }
        }
        return rslt;
    }
};