class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        vector<int> alpha1(26, 0);
        vector<int> alpha2(26, 0);
        for(int i = 0; i < s.size(); i++) {
            alpha1[s[i] - 'a']++;
            alpha2[t[i] - 'a']++;
        }
        return alpha1 == alpha2;
    }
};