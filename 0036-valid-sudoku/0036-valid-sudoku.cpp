class Solution {
public:

    bool singlecheck(vector<vector<char>> &board, int row, int col, char num) {
        if (board[row][col] == '.') return true;

        int countx = 0, county = 0, countb = 0;
        for (int i = 0; i < 9; i++) {
            //row
            if (board[row][i] == (num)) countx++;

            //column
            if (board[i][col] == (num)) county++;; 
        }

        //checking in box
        int stbr = (row/3) * 3, stbc = (col/3) * 3;
        for (int i = stbr; i < stbr + 3; i++) {
            for (int j = stbc; j < stbc + 3; j++) {
                if (board[i][j] == (num)) countb++;
            }
         }
    
        // cout << board[row][col] << " " << row << " " << col << endl;
        return (countx == 1 &&  county == 1 && countb == 1);
    }

    bool isValidSudoku(vector<vector<char>>& board) {
        for (int row = 0; row<board.size(); row++) {
            for (int col = 0; col < board.size(); col++) {
                if (!singlecheck(board, row, col, board[row][col])) return false;
            }
        }

        return true;
    }
};