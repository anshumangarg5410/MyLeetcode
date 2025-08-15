class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int, unordered_set<int>> reservedRows;

        for (auto& seat : reservedSeats) {
            reservedRows[seat[0]].insert(seat[1]);
        }

        int result = (n - reservedRows.size()) * 2;

        for (auto&  reservedseats: reservedRows) {
            unordered_set<int> seats = reservedseats.second;
            bool left = true, middle = true, right = true;

            for (int i = 2; i <= 5; ++i)
                if (seats.count(i)) left = false;

            for (int i = 4; i <= 7; ++i)
                if (seats.count(i)) middle = false;

            for (int i = 6; i <= 9; ++i)
                if (seats.count(i)) right = false;

            if (left && right)
                result += 2;
            else if (left || middle || right)
                result += 1;
        }

        return result;
    }
};
