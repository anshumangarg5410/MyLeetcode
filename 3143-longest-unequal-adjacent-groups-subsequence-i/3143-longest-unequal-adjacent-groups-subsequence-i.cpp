class Solution {
public:
    vector<string> getLongestSubsequence(vector<string>& words, vector<int>& groups) {
        // unordered_map<string, int> freq; vector<string> result; 
        // result.push_back(words[0]);
        // for(int i = 0; i<groups.size(); i++) freq[words[i]] = groups[i]; int i = 0;
        // int initial = freq[words[0]];
        // while (i < words.size() - 1) {
        // if (initial != freq[words[i+1]]){ 
        //     result.push_back(words[i+1]); 
        // }
        // initial = freq[words[i+1]];
        // i++;
        // }
        // return result;

        vector<string> result;
        if (words.empty()) return result;

        result.push_back(words[0]);
        int initial = groups[0];
        
        for (int i = 1; i < words.size(); i++) {
            if (groups[i] != initial) {
                result.push_back(words[i]);
                initial = groups[i];
            }
        }
        
        return result;
    }
};