class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        // unordered_map<char, int> freq;
        // int size = words.size();
        // vector<string> result;
        // for(string word : words) {
        //     for (char al : word) {
        //         freq[al]++;
        //     }
        // }
        // for (auto pair : freq) {
        //     if (pair.second >= size){
        //         for(int i = 0; i<pair.second / size; i++) result.push_back(string(1, pair.first));
        //     } 
        //     cout << pair.first << ">" << pair.second << endl;
        // }

        // return result;

        vector<int> freq(26, INT_MAX);
        for(string word : words) {
            vector<int> singfreq(26, 0);

            for(char al : word) {
                singfreq[al - 'a']++;
            }

            for (int i = 0; i<26; i++){
                freq[i] = min(freq[i], singfreq[i]);
            }
        }
        vector<string> result;
        for (int i = 0; i<26; i++){
            while (freq[i]-- > 0) result.push_back(string(1, 'a' + i));
        }
        return result;
    }
};