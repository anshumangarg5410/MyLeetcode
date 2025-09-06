class Solution {
public:

    bool safeornot(vector<string> board, int row, int col) {
        //checking for row
        int n = board.size();
        for (int i = 0; i<n; i++) {

            //checking for row
            if (board[row][i] == 'Q') return false;

            //checking for col
            if (board[i][col] == 'Q') return false;
        }

        //checking for diagonals

        //upper-left
        for (int i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //upper-right
        for (int i = row, j = col; i >= 0 && j < n ; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        //lower-left
        for (int i = row, j = col; i < n && j >= 0 ; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //lower-right
        for (int i = row, j = col; i < n && j < n ; i++, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    void nquene(vector<string> &board, vector<vector<string>> &ans, int row, int n) {
        if (row == n) {
            // cout << "base case" << endl;
            ans.push_back(board);
            return;
        }

        for (int i = 0; i<n; i++) {

            if (safeornot(board, row, i)) {
                // cout << "I M IN" << endl;

                board[row][i] = 'Q';

                nquene(board, ans, row + 1, n);

                board[row][i] = '.';

            }

            // cout << "not in" << endl;
        }




    }

    vector<vector<string>> solveNQueens(int n) {
        vector<string> board(n, string(n, '.'));
        vector<vector<string>> ans;
        nquene(board, ans, 0, n);
        return ans;
    }
};