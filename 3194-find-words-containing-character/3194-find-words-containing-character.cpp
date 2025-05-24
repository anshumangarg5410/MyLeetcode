class Solution {
public:
    vector<int> findWordsContaining(vector<string>& words, char x) {
        vector<int> result; int o = 0;
        for(string i : words) {
            for (char j : i) {
                if (j == x) {
                result.push_back(o);
                break;
                }
            } o++;
        }
        return result;
    }
};