class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        if ((mat.size() * mat[0].size()) != (r * c)) return mat;
        cout << mat.size() << " " << mat[0].size() << endl;
        vector<vector<int>> result(r, vector<int>(c, 0)); vector<int> temp;
        for(int i = 0; i<mat.size(); i++) for(int j = 0; j<mat[0].size(); j++) temp.push_back(mat[i][j]);
        int count = 0;
        for(int i = 0; i<r; i++) for(int j = 0; j<c; j++) result[i][j] = temp[count++];
        // for(int i : temp) cout << i << endl;
        return result;
    }
};