class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1 || s.size() < numRows) return s;
        int step = 1; vector<string> rows(numRows); int row = 0;
        for(char i : s) {
            rows[row] += i;
            if (row == 0) step = 1;
            else if (row == numRows - 1) step = -1;
            row += step;
        }
        string result = "";
        for(string i : rows) result += i;
        return result;
    }
};

