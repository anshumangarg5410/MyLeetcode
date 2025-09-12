class Solution {
public:
    bool doesAliceWin(string s) {

        for (char i : s) if (
            i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' ||
            i == 'A' || i == 'E' || i == 'I' || i == 'O' || i == 'U'
        ) return true; 

        return false;

    }
};