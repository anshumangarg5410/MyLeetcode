class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        vector<pair<int, int>> target;
        for(int i = 0; i<matrix.size(); i++){
            for (int j = 0; j<matrix[0].size(); j++){
                if (matrix[i][j] == 0){
                    target.push_back({i,j});
                }
            }
        }
        for(auto &p : target) {
            int row = p.first, col = p.second;
            for(int i = 0; i<matrix.size(); i++) matrix[i][col] = 0;
            for(int i = 0; i<matrix[0].size(); i++) matrix[row][i] = 0;
        }
    }
};