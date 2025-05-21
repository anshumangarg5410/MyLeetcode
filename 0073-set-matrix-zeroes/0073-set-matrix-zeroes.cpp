class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        //METHOD 1: spcae comp here : o(m*n) .. done with this method 
        // vector<pair<int, int>> target;
        // for(int i = 0; i<matrix.size(); i++) {
        //     for(int j = 0; j<matrix[0].size(); j++) {
        //         if (matrix[i][j] == 0) target.push_back({i, j});
        //     }
        // }

        // for (int i = 0; i<target.size(); i++) {
        //     int r = target[i].first, c = target[i].second;
        //     for(int k = 0; k<matrix.size(); k++) {
        //         matrix[k][c] = 0;
        //     }
        //     for(int k = 0; k<matrix[0].size(); k++) {
        //         matrix[r][k] = 0;
        //     }
        // }


        //METHOD 2: try with o(n) space complexity
        int checkrow = 0; int checkcol = 0;
        for(int i = 0; i<matrix.size(); i++) {

            for(int j = 0; j<matrix[0].size(); j++) {
                if (i == 0 && matrix[i][j] == 0) checkrow = 1;
                if (j == 0 && matrix[i][j] == 0) checkcol = 1;
                
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //row check
        for(int i = 1; i<matrix.size(); i++) {
            if (matrix[i][0] == 0) {
                for(int j = 0; j<matrix[0].size(); j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //col check
        for(int i = 1; i<matrix[0].size(); i++) {
            if (matrix[0][i] == 0) {
                for(int j = 0; j<matrix.size(); j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if (checkrow) for(int i = 0; i<matrix[0].size(); i++)  matrix[0][i] = 0;
        if (checkcol) for (int i = 0; i<matrix.size(); i++) matrix[i][0] = 0;

    }
};