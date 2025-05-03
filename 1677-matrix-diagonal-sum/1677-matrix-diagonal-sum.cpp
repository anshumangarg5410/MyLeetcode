class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int rslt = 0;
        int size = mat.size();
        for(int i = 0; i<size; i++){
            rslt += mat[i][i];
            rslt += mat[i][size - i - 1];
        }
        if (size %2 != 0) {
            rslt -= mat[size/2][size/2];
        }
        
        return rslt;
    }
};