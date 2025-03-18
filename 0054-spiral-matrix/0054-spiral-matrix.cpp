class Solution {
public:
    vector<int> outsidespiral(vector<vector<int>> &matrix, vector<vector<int>> &copiedmatrix) {
        vector<int> output;
        int rowsize = matrix[0].size();
        int colsize = matrix.size();

        // first row
        for(int i = 0; i < rowsize; i++) {
            output.push_back(matrix[0][i]);
        }
        for(int i : output) cout << i << endl;//chrck
        if (matrix.size() == 1) return output;

        // last column
        for(int i = 1; i < colsize - 1; i++) {
            output.push_back(matrix[i][rowsize - 1]);
        }
        // for(int i : output) cout << i << endl;//chck
        // last row
        for(int i = rowsize - 1; i >= 0; i--) {
            output.push_back(matrix[colsize - 1][i]);
        }
        // for(int i : output) cout << i << endl;//chck
        if (rowsize == 1) return output;
        // first column
        for(int i = colsize - 2; i > 0; i--) {
            output.push_back(matrix[i][0]);
        }
        // remove first row
        copiedmatrix.erase(copiedmatrix.begin()); 
        // remove last row
        copiedmatrix.pop_back(); 

        // remove first and last columns
        for (int i = 0; i < copiedmatrix.size(); i++) {
            if (!copiedmatrix[i].empty()) {
                copiedmatrix[i].erase(copiedmatrix[i].begin()); 
                if (!copiedmatrix[i].empty()) {
                    copiedmatrix[i].pop_back(); 
                }
            }
        }

        if (!copiedmatrix.empty() && !copiedmatrix[0].empty()) {
            cout << "Recusive call yes" << endl;
            vector<int> innerSpiral = outsidespiral(copiedmatrix, copiedmatrix);
            output.insert(output.end(), innerSpiral.begin(), innerSpiral.end());
        }

        return output;
    }

    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<vector<int>> copiedmatrix = matrix;
        return outsidespiral(matrix, copiedmatrix);
    }
};