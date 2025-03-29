class Solution {
public:
    bool isPalindrome(string s) {
        for(int i = 0; i<s.size(); i++) {
            if (!(isalpha(s[i]) || isdigit(s[i])) || s[i] == ' ') {
                s.erase(i, 1); 
                i--;
            }
            else s[i] = tolower(s[i]);
        }
        string b = s;
        reverse(b.begin(), b.end());
        cout << s << endl;
        cout << b << endl;
        if (s == b) return true;
        return false;
    }
};