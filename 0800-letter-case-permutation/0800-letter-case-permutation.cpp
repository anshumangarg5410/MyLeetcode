class Solution {
public:
    void letter(vector<string>& ans, string& s, int index) {
        if (index == s.size()) {
            ans.push_back(s);
            return;
        }

        if (isdigit(s[index])) {
            letter(ans, s, index + 1);
            return;
        }

        s[index] = tolower(s[index]);
        letter(ans, s, index + 1);

        s[index] = toupper(s[index]);
        letter(ans, s, index + 1);
    }

    vector<string> letterCasePermutation(string s) {
        vector<string> ans;
        letter(ans, s, 0);
        return ans;
    }
};