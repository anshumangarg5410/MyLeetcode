class Solution {
public:
    bool isSubsequence(string s, string t) {
        // vector<int> aplha1(26, 0);
        // vector<int> aplha2(26, 0);
        // for(char i : s) aplha1[i - 'a']++;
        // for(char i : t) aplha2[i - 'a']++;
        // for (int i = 0; i<26; i++) if (aplha1[i] > 0) if (aplha2[i] == 0) return false;
        // return true;
        int tar = 0; int cond = 0; int j = 0;
        for(int i = 0; i<s.size(); i++){
            cout << "abc" << i << " " << j << endl;
            while (j < t.size()){
                if (s[i] == t[j]) {
                    cout << i << " " << j << endl;
                    j++;
                    cond++; break;
                }
                j++;
            }
        }
        if (cond == s.size()) return true;
        else return false;
    }
};  