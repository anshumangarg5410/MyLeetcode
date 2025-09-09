class Solution {
public:

    bool issafe(vector<vector<char>> &board, int row, int col, int num) {

        //checking for row and cols
        for (int i = 0; i < 9; i++) {
            //row
            if (board[row][i] == (num + '0')) return false;

            //column
            if (board[i][col] == (num + '0')) return false; 
        }

        //checking in box
        int stbr = (row/3) * 3, stbc = (col/3) * 3;
        for (int i = stbr; i < stbr + 3; i++) {
            for (int j = stbc; j < stbc + 3; j++) {
                if (board[i][j] == (num + '0')) return false;
            }
         }
    
        return true;

    }

    bool btsudoku(vector<vector<char>> &board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) {
            return btsudoku(board, row + 1, 0);
        }
        if (board[row][col] != '.') return btsudoku(board, row, col + 1);

        for (int num = 1; num <= 9; num++) {
            if (issafe(board, row, col, num)) {

                board[row][col] = (num + '0');

                if (btsudoku(board, row, col + 1) ) return true;

                board[row][col] = '.';

            }
        }
        return false;
    } 

    void solveSudoku(vector<vector<char>>& board) {
        btsudoku(board, 0, 0);
    }
};